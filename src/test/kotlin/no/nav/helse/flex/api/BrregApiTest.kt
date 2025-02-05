package no.nav.helse.flex.api

import no.nav.helse.flex.FellesTestOppsett
import no.nav.helse.flex.skapAzureJwt
import no.nav.helse.flex.testdata.lagRolleutskriftSoapRespons
import no.nav.security.mock.oauth2.MockOAuth2Server
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldNotBeNull
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
            brregSoapServer.enqueue(
                MockResponse()
                    .setHeader("Content-Type", "application/xml")
                    .setBody(lagRolleutskriftSoapRespons()),
            )

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
}
