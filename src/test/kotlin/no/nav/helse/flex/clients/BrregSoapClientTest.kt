package no.nav.helse.flex.clients

import no.nav.helse.flex.testdata.lagRollerSoapResponse
import no.nav.helse.flex.testdata.lagRolleutskriftErrorSoapRespons
import no.nav.helse.flex.testdata.lagRolleutskriftPersonIkkeFunnetSoapRespons
import no.nav.helse.flex.testdata.lagRolleutskriftSoapRespons
import no.nav.helse.flex.testdata.wrapWithRolleutskriftXmlEnvelope
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
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse(headerHovedStatus = 0))
                }
            brregSoapClient.hentStatus().erOk.shouldBeTrue()
        }

        @Test
        fun `burde ha status ikke ok ved feil status`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse(headerHovedStatus = -1))
                }

            brregSoapClient.hentStatus().erOk.shouldBeFalse()
        }

        @Test
        fun `burde ha status ikke ok ved feil i soap api`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setResponseCode(HttpStatus.UNAUTHORIZED.value())
                }

            invoking { brregSoapClient.hentStatus() } `should throw` BrregServerException::class
        }

        @Test
        fun `burde ha riktig status melding`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse(headerHovedStatus = 500))
                }

            brregSoapClient.hentStatus().melding `should be equal to`
                "hovedStatus: 500, underStatuser: 0: Data returnert, 1180: Enhet 971524553 har ikke Rolleblokk 2"
        }
    }

    @Nested
    inner class HentRoller {
        @Test
        fun `burde returnere roller`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRolleutskriftSoapRespons())
                }
            val roller = brregSoapClient.hentRoller("11111111111")

            roller.shouldHaveSize(4)
            roller.forEach { it.organisasjonsnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolletype.beskrivelse `should be equal to` Rolletype.INNH.beskrivelse
                it[0].organisasjonsnavn `should be equal to` "SELSKAP AS"
                it[1].rolletype.beskrivelse `should be equal to` Rolletype.DTPR.beskrivelse
                it[1].organisasjonsnavn `should be equal to` "DIDGERIDOO AS"
                it[2].rolletype.beskrivelse `should be equal to` Rolletype.DTSO.beskrivelse
                it[2].organisasjonsnavn `should be equal to` "ILA AS"
                it[3].rolletype.beskrivelse `should be equal to` Rolletype.MEDL.beskrivelse
                it[3].organisasjonsnavn `should be equal to` "NAV Boretteslag"
            }
        }

        @Test
        fun `burde håndtere NOT_FOUND feil i responsHeader fra brreg og returnere tom liste`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRolleutskriftPersonIkkeFunnetSoapRespons("00000000000"))
                }

            val roller = brregSoapClient.hentRoller("00000000000")
            roller.shouldHaveSize(0)
        }

        @Test
        fun `burde håndtere feil i soap respons og kaste server exception`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody("Feil i soap respons")
                }

            invoking { brregSoapClient.hentRoller("11111111111") } `should throw` BrregServerException::class
        }

        @Test
        fun `burde håndtere feil i deserialisering av soap respons og kaste deserialisering exception`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(wrapWithRolleutskriftXmlEnvelope("test"))
                }

            invoking { brregSoapClient.hentRoller("11111111111") } `should throw` BrregDeserializationException::class
        }

        @Test
        fun `burde håndtere feil i responseHeader fra Brreg og kaste client exception`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRolleutskriftErrorSoapRespons(headerHovedStatus = -100))
                }

            invoking { brregSoapClient.hentRoller("11111111111") } `should throw` BrregClientException::class
        }
    }
}
