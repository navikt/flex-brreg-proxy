package no.nav.helse.flex.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.helse.flex.clients.BrregStatus
import no.nav.helse.flex.clients.Rolletype
import no.nav.helse.flex.config.objectMapper
import no.nav.helse.flex.config.serialisertTilString
import no.nav.helse.flex.testdata.*
import no.nav.helse.flex.testoppsett.*
import no.nav.security.mock.oauth2.MockOAuth2Server
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.QueueDispatcher
import org.amshove.kluent.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@FellesTestOppsett
@ApiTestOppsett
@MockServerTestOppsett
@TestPropertySource(
    properties = [
        "spring.profiles.active=dev",
    ],
)
class BrregApiStubTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var oauthServer: MockOAuth2Server

    @Autowired
    lateinit var brregStubServer: MockWebServer

    @AfterEach
    fun resetBrregSoapServer() {
        brregStubServer.dispatcher = QueueDispatcher()
    }

    @Nested
    inner class BrregStatusOkEndepunkt {
        @Test
        fun `burde ha status ok`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagBrregStubIsAliveResponse(true))
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
            brregStubServer.dispatcher =
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
        fun `burde ha status ikke ok ved feil i api`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setResponseCode(HttpStatus.UNAUTHORIZED.value())
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
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(brregStubResponse(fnr = "11111111111"))
                }
            mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                .andExpect(MockMvcResultMatchers.status().isOk)
        }
    }

    @Nested
    inner class BrregStatusEndepunkt {
        @Test
        fun `burde ha status riktig status`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(brregStubResponse(fnr = "11111111111"))
                }

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val status: BrregStatus = objectMapper.readValue(result)
            status.erOk `should be equal to` false
        }

        @Test
        fun `burde ikke kreve authentisering`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(brregStubResponse(fnr = "11111111111"))
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
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(brregStubResponse(fnr = "11111111111"))
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
            roller.size `should be equal to` 1
            roller.forEach { it.orgnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolletype.beskrivelse `should be equal to` Rolletype.INNH.beskrivelse
                it[0].orgnavn `should be equal to` "SELSKAP AS"
            }
        }

        @Test
        fun `burde kun returnere rolletyper som er spesifisert`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/json")
                        .setBody(brregStubResponse(fnr = "11111111111"))
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
            roller.size `should be equal to` 1
            roller.forEach { it.orgnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolletype.beskrivelse `should be equal to` Rolletype.INNH.beskrivelse
                it[0].orgnavn `should be equal to` "SELSKAP AS"
            }
        }

        @Test
        fun `burde håndtere 404 feil i stub respons og returnere NOT_FOUND`() {
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

            val token = oauthServer.skapAzureJwt()

            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/roller")
                        .header("Authorization", "Bearer $token")
                        .content("""{"fnr":"00000000000"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isNotFound)
        }

        @Disabled
        @Test
        fun `burde håndtere feil i deserialisering av soap respons og returnere INTERNAL_SERVER_ERROR`() {
            brregStubServer.dispatcher =
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

        @Disabled
        @Test
        fun `burde håndtere feil i responseHeader fra soap respons og returnere BAD_GATEWAY`() {
            brregStubServer.dispatcher =
                simpleDispatcher {
                    MockResponse()
                        .setHeader("Content-Type", "application/xml")
                        .setBody(lagRolleutskriftErrorSoapRespons(headerHovedStatus = -100))
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
                .andExpect(
                    MockMvcResultMatchers.jsonPath("reason").value(
                        "Bad Gateway. Pga feil fra Brreg: <hovedStatus: -100, underStatuser: -200: Test feil>",
                    ),
                )
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
