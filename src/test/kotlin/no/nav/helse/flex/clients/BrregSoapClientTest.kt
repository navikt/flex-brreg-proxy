package no.nav.helse.flex.clients

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import mockwebserver3.QueueDispatcher
import no.nav.helse.flex.testdata.lagRollerSoapResponse
import no.nav.helse.flex.testdata.lagRolleutskriftErrorSoapRespons
import no.nav.helse.flex.testdata.lagRolleutskriftPersonIkkeFunnetSoapRespons
import no.nav.helse.flex.testdata.lagRolleutskriftSoapRespons
import no.nav.helse.flex.testdata.wrapWithRolleutskriftXmlEnvelope
import no.nav.helse.flex.testoppsett.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

@FellesTestOppsett
@BrregSoapClientOppsett
class BrregSoapClientTest {
    @Autowired
    lateinit var brregSoapServer: MockWebServer

    @Autowired
    lateinit var brregSoapClient: BrregSoapClient

    @AfterEach
    fun resetBrregSoapServer() {
        brregSoapServer.dispatcher = QueueDispatcher()
    }

    @Nested
    inner class HentStatus {
        @Test
        fun `burde ha status ok`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(lagRollerSoapResponse(headerHovedStatus = 0))
                        .build()
                }
            brregSoapClient.hentStatus().erOk.shouldBeTrue()
        }

        @Test
        fun `burde ha status ikke ok ved feil status`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(lagRollerSoapResponse(headerHovedStatus = -1))
                        .build()
                }

            brregSoapClient.hentStatus().erOk.shouldBeFalse()
        }

        @Test
        fun `burde ha status ikke ok ved feil i soap api`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .build()
                }

            shouldThrow<BrregServerException> { brregSoapClient.hentStatus() }
        }

        @Test
        fun `burde ha riktig status melding`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(lagRollerSoapResponse(headerHovedStatus = 500))
                        .build()
                }

            brregSoapClient.hentStatus().melding shouldBe
                "hovedStatus: 500, underStatuser: 0: Data returnert, 1180: Enhet 971524553 har ikke Rolleblokk 2"
        }
    }

    @Nested
    inner class HentRoller {
        @Test
        fun `burde returnere roller`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(lagRolleutskriftSoapRespons())
                        .build()
                }
            val roller = brregSoapClient.hentRoller("11111111111")

            roller.shouldHaveSize(4)
            roller.forEach { it.organisasjonsnummer.shouldNotBeBlank() }
            roller.let {
                it[0].rolletype.beskrivelse shouldBe Rolletype.INNH.beskrivelse
                it[0].organisasjonsnavn shouldBe "SELSKAP AS"
                it[1].rolletype.beskrivelse shouldBe Rolletype.DTPR.beskrivelse
                it[1].organisasjonsnavn shouldBe "DIDGERIDOO AS"
                it[2].rolletype.beskrivelse shouldBe Rolletype.DTSO.beskrivelse
                it[2].organisasjonsnavn shouldBe "ILA AS"
                it[3].rolletype.beskrivelse shouldBe Rolletype.MEDL.beskrivelse
                it[3].organisasjonsnavn shouldBe "NAV Boretteslag"
            }
        }

        @Test
        fun `burde håndtere NOT_FOUND feil i responsHeader fra brreg og returnere tom liste`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(lagRolleutskriftPersonIkkeFunnetSoapRespons("00000000000"))
                        .build()
                }

            val roller = brregSoapClient.hentRoller("00000000000")
            roller.shouldHaveSize(0)
        }

        @Test
        fun `burde håndtere feil i soap respons og kaste server exception`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body("Feil i soap respons")
                        .build()
                }

            shouldThrow<BrregServerException> { brregSoapClient.hentRoller("11111111111") }
        }

        @Test
        fun `burde håndtere feil i deserialisering av soap respons og kaste deserialisering exception`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(wrapWithRolleutskriftXmlEnvelope("test"))
                        .build()
                }

            shouldThrow<BrregDeserializationException> { brregSoapClient.hentRoller("11111111111") }
        }

        @Test
        fun `burde håndtere feil i responseHeader fra Brreg og kaste client exception`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse
                        .Builder()
                        .setHeader("Content-Type", "application/xml")
                        .body(lagRolleutskriftErrorSoapRespons(headerHovedStatus = -100))
                        .build()
                }

            shouldThrow<BrregClientException> { brregSoapClient.hentRoller("11111111111") }
        }
    }
}
