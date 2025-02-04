package no.nav.helse.flex

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
import kotlin.collections.set
import kotlin.jvm.java

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
        const val REQUEST_TIMEOUT_MS = 20_000
    }

    private val hentRolleutskriftClient: ErFr = createSoapClientBean(HENT_ROLLEUTSKRIFT_SERVICE_URL)

    fun hentRolleutskrift(fnr: String): generated.rolleutskrift.Grunndata {
        val startMs = System.currentTimeMillis()
        val response =
            try {
                hentRolleutskriftClient.hentRolleutskrift(username, password, fnr)
            } catch (ex: Exception) {
                val endMs = System.currentTimeMillis()
                logger.error("Feil ved henting av rolleutskrift (etter ${endMs - startMs} ms)")
                throw ex
            }
        val deserializedResponse =
            try {
                JAXB.unmarshal(StringReader(response), generated.rolleutskrift.Grunndata::class.java)
            } catch (ex: Exception) {
                logger.error("Feil ved deserialisering av respons", ex)
                throw ex
            }
        return deserializedResponse
    }

    private fun createSoapClientBean(serviceUrl: String): ErFr {
        val factory = JaxWsProxyFactoryBean()
        factory.serviceClass = ErFr::class.java
        factory.address = brregUrl
        factory.handlers.add(HeaderOutHandler(serviceUrl))

        val properties: MutableMap<String, Any> = HashMap()
        // default er 30 sek (30000ms)
        val timeoutMS = REQUEST_TIMEOUT_MS
        properties["javax.xml.ws.client.connectionTimeout"] = timeoutMS
        properties["javax.xml.ws.client.receiveTimeout"] = timeoutMS
        factory.properties = properties

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
