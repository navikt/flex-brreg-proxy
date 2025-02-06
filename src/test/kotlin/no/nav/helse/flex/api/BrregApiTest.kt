package no.nav.helse.flex.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.helse.flex.FellesTestOppsett
import no.nav.helse.flex.config.objectMapper
import no.nav.helse.flex.config.serialisertTilString
import no.nav.helse.flex.simpleDispatcher
import no.nav.helse.flex.skapAzureJwt
import no.nav.helse.flex.testdata.lagRolleutskriftSoapRespons
import no.nav.helse.flex.testdata.wrapWithXmlEnvelope
import no.nav.security.mock.oauth2.MockOAuth2Server
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.amshove.kluent.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class BrregApiTest : FellesTestOppsett() {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var oauthServer: MockOAuth2Server

    @Autowired
    lateinit var brregSoapServer: MockWebServer

    @Nested
    inner class CheckBrregAuth {
        @Test
        fun `burde ikke ha tilgang til brreg`() {
            val result =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .get("/api/v1/sjekk-brreg-tilgang")
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "false"
        }
    }

    @Nested
    inner class HentRolleutskrift {
        @Test
        fun `burde returnere soap respons`() {
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
                            .post("/api/v1/rolleutskrift")
                            .header("Authorization", "Bearer $token")
                            .content("""{"fnr":"11111111111"}""")
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString
            result.shouldNotBeNull()
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
                        .post("/api/v1/rolleutskrift")
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
                        .setBody("test".wrapWithXmlEnvelope())
                }

            val token = oauthServer.skapAzureJwt()

            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/rolleutskrift")
                        .header("Authorization", "Bearer $token")
                        .content("""{"fnr":"11111111111"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isInternalServerError)
        }

        @Test
        fun `burde feile uten token`() {
            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/rolleutskrift")
                        .content("""{"fnr":"11111111111"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isUnauthorized)
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

            val roller: List<Rolle> = objectMapper.readValue(result)
            roller.size `should be equal to` 4
            roller.forEach { it.organisasjonsnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolleType.beskrivelse `should be equal to` RolleType.INNH.beskrivelse
                it[1].rolleType.beskrivelse `should be equal to` RolleType.DTPR.beskrivelse
                it[2].rolleType.beskrivelse `should be equal to` RolleType.DTSO.beskrivelse
                it[3].rolleType.beskrivelse `should be equal to` RolleType.MEDL.beskrivelse
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

            val selvstendigNaringsdrivendeRoller = RolleType.entries.filter { it.erSelvstendigNaringdrivende() }

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

            val roller: List<Rolle> = objectMapper.readValue(result)
            roller.size `should be equal to` 3
            roller.forEach { it.organisasjonsnummer.shouldNotBeNullOrBlank() }
            roller.let {
                it[0].rolleType.beskrivelse `should be equal to` RolleType.INNH.beskrivelse
                it[1].rolleType.beskrivelse `should be equal to` RolleType.DTPR.beskrivelse
                it[2].rolleType.beskrivelse `should be equal to` RolleType.DTSO.beskrivelse
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
                        .setBody("test".wrapWithXmlEnvelope())
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
