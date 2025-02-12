package no.nav.helse.flex.clients

import jakarta.xml.soap.SOAPException
import no.brreg.saksys.grunndata.ws.ErFr
import no.nav.helse.flex.config.logger
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.StringReader
import javax.xml.bind.JAXB
import javax.xml.namespace.QName
import javax.xml.ws.handler.MessageContext
import javax.xml.ws.handler.soap.SOAPHandler
import javax.xml.ws.handler.soap.SOAPMessageContext
import kotlin.jvm.java
import generated.roller.Grunndata as RollerGrunndata
import generated.rolleutskrift.Grunndata as RolleutskriftGrunndata

@Component
class BrregSoapClient(
    @Value("\${BRREG_USERNAME}")
    private val username: String,
    @Value("\${BRREG_PASSWORD}")
    private val password: String,
    @Value("\${BRREG_URL}")
    private val brregUrl: String,
) {
    private val logger = logger()

    companion object {
        const val HENT_ROLLEUTSKRIFT_SERVICE_URL = "http://no/brreg/saksys/grunndata/ws/ErFr/hentRolleutskriftRequest"
        const val HENT_ROLLER_SERVICE_URL = "http://no/brreg/saksys/grunndata/ws/ErFr/hentRollerRequest"

        private val REQUEST_TIMEOUT_MS = 20_000
    }

    private val hentRolleutskriftClient: ErFr = createSoapClientBean(HENT_ROLLEUTSKRIFT_SERVICE_URL)
    private val hentRollerClient: ErFr = createSoapClientBean(HENT_ROLLER_SERVICE_URL)

    fun hentRoller(orgnummer: String): RollerGrunndata {
        val startMs = System.currentTimeMillis()
        val response =
            try {
                hentRollerClient.hentRoller(username, password, orgnummer)
            } catch (ex: Exception) {
                val endMs = System.currentTimeMillis()
                val melding = "Feil ved henting av roller (etter ${endMs - startMs} ms)"
                logger.error(melding)
                throw SoapServiceException(melding, ex)
            }
        val deserializedResponse =
            try {
                JAXB.unmarshal(StringReader(response), RollerGrunndata::class.java)
            } catch (ex: Exception) {
                val melding = "Feil ved deserialisering av roller respons"
                logger.error(melding)
                throw SoapDeserializationException(melding, ex)
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
                logger.error(melding)
                throw SoapServiceException(melding, ex)
            }
        val deserializedResponse =
            try {
                JAXB.unmarshal(StringReader(response), RolleutskriftGrunndata::class.java)
            } catch (ex: Exception) {
                val melding = "Feil ved deserialisering av respons"
                logger.error(melding)
                throw SoapDeserializationException(melding, ex)
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
                "javax.xml.ws.client.connectionTimeout" to timeoutMS,
                "javax.xml.ws.client.receiveTimeout" to timeoutMS,
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
