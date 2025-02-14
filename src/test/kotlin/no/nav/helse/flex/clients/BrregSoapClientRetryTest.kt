package no.nav.helse.flex.clients

import no.nav.helse.flex.testoppsett.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@FellesTestOppsett
@RetryTestOppsett
@BrregSoapClientOppsett
class BrregSoapClientRetryTest {
    @Autowired
    lateinit var brregSoapClient: BrregSoapClient

    @Autowired
    lateinit var brregSoapServer: MockWebServer

    @Test
    fun `burde retrye på feil ved hentRoller`() {
        var antallKall = 0
        brregSoapServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse()
                    .setHeader("Content-Type", "application/xml")
                    .setBody("Feil i soap respons")
            }

        runCatching {
            brregSoapClient.hentRoller("fnr")
        }
        antallKall `should be equal to` 3
    }

    @Test
    fun `burde retrye på feil ved hentStatus`() {
        var antallKall = 0
        brregSoapServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse()
                    .setHeader("Content-Type", "application/xml")
                    .setBody("Feil i soap respons")
            }

        runCatching {
            brregSoapClient.hentStatus()
        }
        antallKall `should be equal to` 3
    }
}
