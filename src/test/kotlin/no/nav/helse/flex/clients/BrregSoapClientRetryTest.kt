package no.nav.helse.flex.clients

import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import no.nav.helse.flex.testdata.lagRolleutskriftErrorSoapRespons
import no.nav.helse.flex.testdata.lagRolleutskriftPersonIkkeFunnetSoapRespons
import no.nav.helse.flex.testoppsett.BrregSoapClientOppsett
import no.nav.helse.flex.testoppsett.FellesTestOppsett
import no.nav.helse.flex.testoppsett.RetryTestOppsett
import no.nav.helse.flex.testoppsett.simpleDispatcher
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
                MockResponse
                    .Builder()
                    .setHeader("Content-Type", "application/xml")
                    .body("Feil i soap respons")
                    .build()
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
                MockResponse
                    .Builder()
                    .setHeader("Content-Type", "application/xml")
                    .body("Feil i soap respons")
                    .build()
            }

        runCatching {
            brregSoapClient.hentStatus()
        }
        antallKall `should be equal to` 3
    }

    @Test
    fun `burde ikke retrye ved NOT_FOUND når person ikke finnes`() {
        var antallKall = 0
        brregSoapServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse
                    .Builder()
                    .setHeader("Content-Type", "application/xml")
                    .body(lagRolleutskriftPersonIkkeFunnetSoapRespons())
                    .build()
            }

        brregSoapClient.hentRoller("00000000000")

        antallKall `should be equal to` 1
    }

    @Test
    fun `burde ikke retrye ved BrregClientException`() {
        var antallKall = 0
        brregSoapServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse
                    .Builder()
                    .setHeader("Content-Type", "application/xml")
                    .body(lagRolleutskriftErrorSoapRespons(headerHovedStatus = -100))
                    .build()
            }

        runCatching { brregSoapClient.hentRoller("00000000000") }

        antallKall `should be equal to` 1
    }
}
