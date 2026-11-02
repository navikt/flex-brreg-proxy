package no.nav.helse.flex.clients

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import mockwebserver3.QueueDispatcher
import no.nav.helse.flex.testdata.*
import no.nav.helse.flex.testoppsett.*
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

            shouldThrow<BrregClientException> { brregStubClient.hentStatus() }
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
            status.melding shouldBe "\"OK\""
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
            roller.size shouldBe 1
            roller.forEach { it.organisasjonsnummer.shouldNotBeBlank() }
            roller.let {
                it[0].rolletype.beskrivelse shouldBe Rolletype.INNH.beskrivelse
                it[0].organisasjonsnavn shouldBe "SELSKAP AS"
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

            brregStubClient.hentRoller(fnr = "_").shouldBeEmpty()
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

            shouldThrow<Exception> { brregStubClient.hentRoller(fnr = "_") }
        }
    }
}
