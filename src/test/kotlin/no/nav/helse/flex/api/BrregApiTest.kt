package no.nav.helse.flex.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.helse.flex.clients.BrregStatus
import no.nav.helse.flex.clients.Rolletype
import no.nav.helse.flex.config.objectMapper
import no.nav.helse.flex.config.serialisertTilString
import no.nav.helse.flex.testdata.lagRollerSoapResponse
import no.nav.helse.flex.testdata.lagRolleutskriftErrorSoapRespons
import no.nav.helse.flex.testdata.lagRolleutskriftSoapRespons
import no.nav.helse.flex.testdata.wrapWithRolleutskriftXmlEnvelope
import no.nav.helse.flex.testoppsett.*
import no.nav.security.mock.oauth2.MockOAuth2Server
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.QueueDispatcher
import org.amshove.kluent.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@FellesTestOppsett
@ApiTestOppsett
@MockServerTestOppsett
class BrregApiTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var oauthServer: MockOAuth2Server

    @Autowired
    lateinit var brregSoapServer: MockWebServer

    @AfterEach
    fun resetBrregSoapServer() {
        brregSoapServer.dispatcher = QueueDispatcher()
    }

    @Nested
    inner class BrregStatusOkEndepunkt {
        @Test
        fun `burde ha status ok`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse(headerHovedStatus = 0))
                }

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "true"
        }

        @Test
        fun `burde ha status ikke ok ved feil status`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse(headerHovedStatus = -1))
                }

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "false"
        }

        @Test
        fun `burde ha status ikke ok ved feil i soap api`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setStatus(HttpStatus.UNAUTHORIZED.name)
                }

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "false"
        }

        @Test
        fun `burde ikke kreve authentisering`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse())
                }
            mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                .andExpect(MockMvcResultMatchers.status().isOk)
        }
    }

    @Nested
    inner class BrregStatusEndepunkt {
        @Test
        fun `burde ha riktig status`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse(headerHovedStatus = 500))
                }

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val status: BrregStatus = objectMapper.readValue(result)
            status.hovedStatus `should be equal to` 500
        }

        @Test
        fun `burde ikke kreve authentisering`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRollerSoapResponse())
                }
            mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status"))
                .andExpect(MockMvcResultMatchers.status().isOk)
        }
    }

    @Nested
    inner class HentRollerEndepunkt {
        @Test
        fun `burde returnere roller`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRolleutskriftSoapRespons())
                }

            val token = oauthServer.skapAzureJwt()

            val result =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .post("/api/v1/roller")
                            .header("Authorization", "Bearer $token")
                            .content("""{"fnr":"11111111111"}""")
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val rollerDto: RollerDto = objectMapper.readValue(result)
            val roller = rollerDto.roller
            roller.size `should be equal to` 4
            roller.forEach { it.orgnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolletype.beskrivelse `should be equal to` Rolletype.INNH.beskrivelse
                it[0].orgnavn `should be equal to` "SELSKAP AS"
                it[1].rolletype.beskrivelse `should be equal to` Rolletype.DTPR.beskrivelse
                it[1].orgnavn `should be equal to` "DIDGERIDOO AS"
                it[2].rolletype.beskrivelse `should be equal to` Rolletype.DTSO.beskrivelse
                it[2].orgnavn `should be equal to` "ILA AS"
                it[3].rolletype.beskrivelse `should be equal to` Rolletype.MEDL.beskrivelse
                it[3].orgnavn `should be equal to` "NAV Boretteslag"
            }
        }

        @Test
        fun `burde kun returnere rolletyper som er spesifisert`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRolleutskriftSoapRespons())
                }

            val token = oauthServer.skapAzureJwt()

            val selvstendigNaringsdrivendeRoller = Rolletype.entries.filter { it.erSelvstendigNaringdrivende() }

            val result =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .post("/api/v1/roller")
                            .header("Authorization", "Bearer $token")
                            .content(HentRollerRequest("11111111111", selvstendigNaringsdrivendeRoller).serialisertTilString())
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val rollerDto: RollerDto = objectMapper.readValue(result)
            val roller = rollerDto.roller
            roller.size `should be equal to` 3
            roller.forEach { it.orgnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolletype.beskrivelse `should be equal to` Rolletype.INNH.beskrivelse
                it[0].orgnavn `should be equal to` "SELSKAP AS"
                it[1].rolletype.beskrivelse `should be equal to` Rolletype.DTPR.beskrivelse
                it[1].orgnavn `should be equal to` "DIDGERIDOO AS"
                it[2].rolletype.beskrivelse `should be equal to` Rolletype.DTSO.beskrivelse
                it[2].orgnavn `should be equal to` "ILA AS"
            }
        }

        @Test
        fun `burde håndtere feil i soap respons og returnere BAD_GATEWAY`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody("Feil i soap respons")
                }

            val token = oauthServer.skapAzureJwt()

            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/roller")
                        .header("Authorization", "Bearer $token")
                        .content("""{"fnr":"11111111111"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isBadGateway)
        }

        @Test
        fun `burde håndtere feil i deserialisering av soap respons og returnere INTERNAL_SERVER_ERROR`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(wrapWithRolleutskriftXmlEnvelope("test"))
                }

            val token = oauthServer.skapAzureJwt()

            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/roller")
                        .header("Authorization", "Bearer $token")
                        .content("""{"fnr":"11111111111"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isInternalServerError)
        }

        @Test
        fun `burde håndtere feil i responseHeader fra Brreg og returnere BAD_GATEWAY`() {
            brregSoapServer.dispatcher =
                simpleDispatcher {
                    val res =
                        MockResponse()
                            .setHeader("Content-Type", "application/xml")
                            .setBody(lagRolleutskriftErrorSoapRespons(headerHovedStatus = -100))
                    println(
                        """
                        Mock body:
                        ---
                        ${res.getBody()?.readString(Charsets.UTF_8)}
                        ---
                        """.trimIndent(),
                    )
                    res
                }

            val token = oauthServer.skapAzureJwt()

            val res =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .post("/api/v1/roller")
                            .header("Authorization", "Bearer $token")
                            .content("""{"fnr":"11111111111"}""")
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isBadGateway)
                    .andExpect(
                        MockMvcResultMatchers.jsonPath("reason").value(
                            "Bad Gateway. Pga feil fra Brreg: <hovedStatus: -100, underStatuser: -200: Test-feil>",
                        ),
                    ).andReturn()
                    .response.contentAsString

            println("Server response: $res")
        }

        @Test
        fun `burde feile uten token`() {
            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/roller")
                        .content("""{"fnr":"11111111111"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isUnauthorized)
        }
    }
}
