package no.nav.helse.flex.clients

import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import mockwebserver3.QueueDispatcher
import no.nav.helse.flex.testdata.*
import no.nav.helse.flex.testoppsett.*
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
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .body(lagBrregStubIsAliveResponse(true))
                        .build()
                }

            val status = brregStubClient.hentStatus()
            status.erOk.shouldBeTrue()
        }

        @Test
        fun `burde ha status ikke ok ved feil status`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .body(lagBrregStubIsAliveResponse(false))
                        .build()
                }

            val status = brregStubClient.hentStatus()
            status.erOk.shouldBeFalse()
        }

        @Test
        fun `burde kaste exception ved feil i api`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .body(lagBrregStubIsAliveResponse(false))
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .build()
                }

            invoking { brregStubClient.hentStatus() } `should throw` BrregClientException::class
        }

        @Test
        fun `burde ha riktig status melding`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .body(lagBrregStubIsAliveResponse(true))
                        .build()
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
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .body(lagBrregStubResponse(fnr = "11111111111"))
                        .build()
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
        fun `burde håndtere 404 feil i stub respons og returnere tom liste`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .code(HttpStatus.NOT_FOUND.value())
                        .body(
                            """
                            {
                              "timestamp": "2025-02-11T15:37:51.213+00:00",
                              "status": 404,
                              "error": "Not Found",
                              "message": "Kunne ikke finne person med fnr:00000000000",
                              "path": "/api/v2/rolleoversikt"
                            }
                            """.trimIndent(),
                        ).build()
                }

            brregStubClient.hentRoller(fnr = "_").`should be empty`()
        }

        @Test
        fun `burde håndtere feil i deserialisering av respons og kaste exception`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/json")
                        .body("{}")
                        .build()
                }

            invoking { brregStubClient.hentRoller(fnr = "_") } `should throw` Exception::class
        }
    }
}
