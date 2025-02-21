package no.nav.helse.flex.clients

import no.nav.helse.flex.testdata.*
import no.nav.helse.flex.testoppsett.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.QueueDispatcher
import org.amshove.kluent.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

@FellesTestOppsett
@BrregStubClientOppsett
class BrregStubClientTest {
    @Autowired
    lateinit var brregStubServer: MockWebServer

    @Autowired
    lateinit var brregStubClient: BrregStubClient

    @AfterEach
    fun resetBrregSoapServer() {
        brregStubServer.dispatcher = QueueDispatcher()
    }

    @Nested
    inner class HentStatus {
        @Test
        fun `burde ha status ok`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(lagBrregStubIsAliveResponse(true))
                }

            val status = brregStubClient.hentStatus()
            status.erOk.shouldBeTrue()
        }

        @Test
        fun `burde ha status ikke ok ved feil status`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(lagBrregStubIsAliveResponse(false))
                }

            val status = brregStubClient.hentStatus()
            status.erOk.shouldBeFalse()
        }

        @Test
        fun `burde kaste exception ved feil i api`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(lagBrregStubIsAliveResponse(false))
                        .setResponseCode(HttpStatus.UNAUTHORIZED.value())
                }

            invoking { brregStubClient.hentStatus() } `should throw` BrregClientException::class
        }

        @Test
        fun `burde ha riktig status melding`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(lagBrregStubIsAliveResponse(true))
                }

            val status = brregStubClient.hentStatus()
            status.melding `should be equal to` "\"OK\""
        }
    }

    @Nested
    inner class HentRoller {
        @Test
        fun `burde returnere roller`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(lagBrregStubResponse(fnr = "11111111111"))
                }

            val roller = brregStubClient.hentRoller(fnr = "11111111111")
            roller.size `should be equal to` 1
            roller.forEach { it.organisasjonsnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolletype.beskrivelse `should be equal to` Rolletype.INNH.beskrivelse
                it[0].organisasjonsnavn `should be equal to` "SELSKAP AS"
            }
        }

        @Test
        fun `burde håndtere 404 feil i stub respons og kaste exception`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setResponseCode(HttpStatus.NOT_FOUND.value())
                        .setBody(
                            """
                            {
                              "timestamp": "2025-02-11T15:37:51.213+00:00",
                              "status": 404,
                              "error": "Not Found",
                              "message": "Kunne ikke finne person med fnr:00000000000",
                              "path": "/api/v2/rolleoversikt"
                            }
                            """.trimIndent(),
                        )
                }

            invoking { brregStubClient.hentRoller(fnr = "_") } `should throw` BrregClientException::class
        }

        @Test
        fun `burde håndtere feil i deserialisering av respons og kaste exception`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody("{}")
                }

            invoking { brregStubClient.hentRoller(fnr = "_") } `should throw` Exception::class
        }
    }
}
