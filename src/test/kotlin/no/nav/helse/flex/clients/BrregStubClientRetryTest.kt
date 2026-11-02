package no.nav.helse.flex.clients

import io.kotest.matchers.shouldBe
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import no.nav.helse.flex.testoppsett.*
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
                MockResponse
                    .Builder()
                    .setHeader("Content-Type", "application/json")
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build()
            }

        runCatching {
            brregStubClient.hentRoller("fnr")
        }
        antallKall shouldBe 3
    }

    @Test
    fun `burde retrye på feil ved hentStatus`() {
        var antallKall = 0
        brregStubServer.dispatcher =
            simpleDispatcher {
                antallKall++
                MockResponse
                    .Builder()
                    .setHeader("Content-Type", "application/json")
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build()
            }

        runCatching {
            brregStubClient.hentStatus()
        }
        antallKall shouldBe 3
    }
}
