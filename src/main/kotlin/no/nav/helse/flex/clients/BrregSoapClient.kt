package no.nav.helse.flex.clients

import jakarta.xml.bind.JAXB
import jakarta.xml.soap.SOAPException
import jakarta.xml.ws.handler.MessageContext
import jakarta.xml.ws.handler.soap.SOAPHandler
import jakarta.xml.ws.handler.soap.SOAPMessageContext
import no.brreg.saksys.grunndata.ws.ErFr
import no.nav.helse.flex.config.logger
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.apache.cxf.message.Message
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpStatus
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component
import java.io.StringReader
import javax.xml.namespace.QName
import kotlin.jvm.java
import generated.roller.Grunndata as RollerGrunndata
import generated.rolleutskrift.Grunndata as RolleutskriftGrunndata

@Profile("prod")
@Component
class BrregSoapClient(
    @Value("\${BRREG_USERNAME}")
    private val username: String,
    @Value("\${BRREG_PASSWORD}")
    private val password: String,
    @Value("\${BRREG_URL}")
    private val brregUrl: String,
) : BrregClient {
    private val log = logger()

    companion object {
        const val HENT_ROLLEUTSKRIFT_SERVICE_URL = "http://no/brreg/saksys/grunndata/ws/ErFr/hentRolleutskriftRequest"
        const val HENT_ROLLER_SERVICE_URL = "http://no/brreg/saksys/grunndata/ws/ErFr/hentRollerRequest"

        private val REQUEST_TIMEOUT_MS = 20_000
        private val BRREG_UNDERSTATUS_PERSON_IKKE_FUNNET = 180
    }

    private val hentRolleutskriftClient: ErFr = createSoapClientBean(HENT_ROLLEUTSKRIFT_SERVICE_URL)
    private val hentRollerClient: ErFr = createSoapClientBean(HENT_ROLLER_SERVICE_URL)

    @Retryable(
        include = [BrregServerException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    override fun hentStatus(): BrregStatus = hentResponsStatus()

    @Retryable(
        include = [BrregServerException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    override fun hentRoller(fnr: String): List<RolleDto> = hentRollerBrregSoap(fnr)

    internal fun hentResponsStatus(): BrregStatus {
        val navOrgnummerForSjekk = "889640782"
        val respons = hentRollerGrunndata(orgnummer = navOrgnummerForSjekk)
        val status = lagStatusMelding(respons.responseHeader)
        return status
    }

    fun lagStatusMelding(responseHeader: RolleutskriftGrunndata.ResponseHeader): BrregStatus {
        val hovedStatus = responseHeader.hovedStatus
        val erOK = hovedStatus == 0
        val underStatuser = responseHeader.underStatus.underStatusMelding
        val underStatusMelding = underStatuser.joinToString(", ") { "${it.kode}: ${it.value}" }
        return BrregStatus(
            melding = "hovedStatus: $hovedStatus, underStatuser: $underStatusMelding",
            erOk = erOK,
            httpStatus =
                if (erOK) {
                    HttpStatus.OK
                } else if (underStatuser.any { it.kode == BRREG_UNDERSTATUS_PERSON_IKKE_FUNNET }) {
                    HttpStatus.NOT_FOUND
                } else {
                    HttpStatus.BAD_REQUEST
                },
        )
    }

    fun lagStatusMelding(responseHeader: RollerGrunndata.ResponseHeader): BrregStatus {
        val hovedStatus = responseHeader.hovedStatus
        val erOK = hovedStatus == 0
        val underStatuser = responseHeader.underStatus.underStatusMelding
        val underStatusMelding = underStatuser.joinToString(", ") { "${it.kode}: ${it.value}" }
        return BrregStatus(
            melding = "hovedStatus: $hovedStatus, underStatuser: $underStatusMelding",
            erOk = erOK,
            httpStatus =
                if (erOK) {
                    HttpStatus.OK
                } else if (underStatuser.any { it.kode == BRREG_UNDERSTATUS_PERSON_IKKE_FUNNET }) {
                    HttpStatus.NOT_FOUND
                } else {
                    HttpStatus.BAD_REQUEST
                },
        )
    }

    internal fun hentRollerBrregSoap(fnr: String): List<RolleDto> {
        val grunndata = hentRolleutskrift(fnr = fnr)

        val status = lagStatusMelding(grunndata.responseHeader)
        if (!status.erOk || grunndata.melding == null) {
            if (status.httpStatus != HttpStatus.NOT_FOUND) {
                log.error("Feil fra Brreg API ved henting av roller. Status: ${status.anonymisertMelding()}")
            }
            throw BrregClientException(
                message = "Feil fra Brreg API ved henting av roller",
                httpStatus = status.httpStatus.value(),
                httpMessage = status.anonymisertMelding(),
            )
        }

        return grunndata.melding.roller.enhet
            .map {
                val rolleDto =
                    RolleDto(
                        rolletype = Rolletype.fromBeskrivelse(it.rolleBeskrivelse.value),
                        organisasjonsnummer = it.orgnr.value.toString(),
                        organisasjonsnavn = it.navn.navn1,
                    )
                if (rolleDto.rolletype == Rolletype.UKJENT) {
                    log.warn("Ukjent rolletype: ${it.rolleBeskrivelse.value}")
                }
                rolleDto
            }
    }

    fun hentRollerGrunndata(orgnummer: String): RollerGrunndata {
        val startMs = System.currentTimeMillis()
        val response =
            try {
                hentRollerClient.hentRoller(username, password, orgnummer)
            } catch (ex: Exception) {
                val endMs = System.currentTimeMillis()
                val melding = "Feil ved henting av roller (etter ${endMs - startMs} ms)"
                log.error(melding)
                throw BrregServerException(melding, ex)
            }
        val deserializedResponse =
            try {
                JAXB.unmarshal(StringReader(response), RollerGrunndata::class.java)
            } catch (ex: Exception) {
                val melding = "Feil ved deserialisering av roller respons"
                log.error(melding)
                throw BrregDeserializationException(melding, ex)
            }
        return deserializedResponse
    }

    fun hentRolleutskrift(fnr: String): RolleutskriftGrunndata {
        val startMs = System.currentTimeMillis()
        val response =
            try {
                hentRolleutskriftClient.hentRolleutskrift(username, password, fnr)
            } catch (ex: Exception) {
                val endMs = System.currentTimeMillis()
                val melding = "Feil ved henting av rolleutskrift (etter ${endMs - startMs} ms)"
                log.error(melding)
                throw BrregServerException(melding, ex)
            }
        val deserializedResponse =
            try {
                JAXB.unmarshal(StringReader(response), RolleutskriftGrunndata::class.java)
            } catch (ex: Exception) {
                val melding = "Feil ved deserialisering av respons"
                log.error(melding)
                throw BrregDeserializationException(melding, ex)
            }
        return deserializedResponse
    }

    private fun createSoapClientBean(serviceUrl: String): ErFr {
        val factory = JaxWsProxyFactoryBean()
        factory.serviceClass = ErFr::class.java
        factory.address = brregUrl
        factory.handlers.add(HeaderOutHandler(serviceUrl))

        // default er 30 sek (30000ms)
        val timeoutMS = REQUEST_TIMEOUT_MS
        factory.properties =
            mapOf(
                Message.CONNECTION_TIMEOUT to timeoutMS,
                Message.RECEIVE_TIMEOUT to timeoutMS,
            )
        return factory.create() as ErFr
    }
}

private class HeaderOutHandler(
    private val url: String,
) : SOAPHandler<SOAPMessageContext?> {
    companion object {
        private val log = LoggerFactory.getLogger(HeaderOutHandler::class.java)
    }

    override fun handleMessage(context: SOAPMessageContext?): Boolean {
        val outbound = context!![MessageContext.MESSAGE_OUTBOUND_PROPERTY] as Boolean?
        if (outbound!!) {
            appendToSoapHeader(context, QName("http://www.w3.org/2005/08/addressing", "Action"), url)
        }
        return true
    }

    private fun appendToSoapHeader(
        context: SOAPMessageContext,
        qName: QName,
        value: String?,
    ) {
        try {
            context.message.soapPart.envelope
                .addHeader()
            val header = context.message.soapPart.envelope.header
            val element = header.addChildElement(qName)
            element.value = value ?: ""
        } catch (e: SOAPException) {
            log.error(e.message)
        }
    }

    override fun handleFault(context: SOAPMessageContext?): Boolean = true

    override fun close(context: MessageContext) { // Nothing to close
    }

    override fun getHeaders(): Set<QName> {
        val headers = HashSet<QName>()
        headers.add(QName("http://www.w3.org/2005/08/addressing", "Action"))
        return headers
    }
}
