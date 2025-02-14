package no.nav.helse.flex.clients

import no.nav.helse.flex.testoppsett.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

@FellesTestOppsett
@RetryTestOppsett
@BrregStubClientOppsett
class BrregStubClientRetryTest {
    @Autowired
    lateinit var brregStubClient: BrregStubClient

    @Autowired
    lateinit var brregStubServer: MockWebServer

    @Test
    fun `burde retrye på feil ved hentRoller`() {
        var antallKall = 0
        brregStubServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            }

        runCatching {
            brregStubClient.hentRoller("fnr")
        }
        antallKall `should be equal to` 3
    }

    @Test
    fun `burde retrye på feil ved hentStatus`() {
        var antallKall = 0
        brregStubServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse()
                    .setHeader("Content-Type", "application/json")
                    .setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            }

        runCatching {
            brregStubClient.hentStatus()
        }
        antallKall `should be equal to` 3
    }
}
