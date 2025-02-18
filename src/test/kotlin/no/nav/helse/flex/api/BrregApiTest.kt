package no.nav.helse.flex.api

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.helse.flex.clients.*
import no.nav.helse.flex.config.objectMapper
import no.nav.helse.flex.config.serialisertTilString
import no.nav.helse.flex.testdata.lagRolle
import no.nav.helse.flex.testoppsett.*
import no.nav.security.mock.oauth2.MockOAuth2Server
import org.amshove.kluent.`should be equal to`
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
@BrregClientFakesOppsett
@ApiTestOppsett
class BrregApiTest {
    @Autowired
    lateinit var brregClient: BrregClientFake

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var oauthServer: MockOAuth2Server

    @AfterEach
    fun reset() {
        brregClient.clear()
    }

    @Nested
    inner class BrregStatusOkEndepunkt {
        @Test
        fun `burde ha status ok`() {
            brregClient.status = BrregStatus("OK", true)

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "true"
        }

        @Test
        fun `burde ha status ikke ok`() {
            brregClient.status = BrregStatus("", false)
            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "false"
        }

        @Test
        fun `burde ha status ikke ok ved BrregServerException i client`() {
            brregClient.hentStatusException = BrregServerException("")

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            result `should be equal to` "false"
        }

        @Test
        fun `burde ha status ikke ok ved BrregClientException i client`() {
            brregClient.hentStatusException = BrregClientException(message = "", httpStatus = HttpStatus.UNAUTHORIZED.value())

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
            mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status-ok"))
                .andExpect(MockMvcResultMatchers.status().isOk)
        }
    }

    @Nested
    inner class BrregStatusEndepunkt {
        @Test
        fun `burde ha riktig status`() {
            brregClient.status = BrregStatus(melding = "OK", erOk = true)

            val result =
                mockMvc
                    .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status"))
                    .andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val status: BrregStatus = objectMapper.readValue(result)
            status.melding `should be equal to` "OK"
            status.erOk `should be equal to` true
        }

        @Test
        fun `burde ikke kreve authentisering`() {
            mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/brreg-status"))
                .andExpect(MockMvcResultMatchers.status().isOk)
        }
    }

    @Nested
    inner class HentRollerEndepunkt {
        @Test
        fun `burde returnere rolle med riktig info`() {
            brregClient.roller =
                listOf(
                    lagRolle(
                        rolletype = Rolletype.INNH,
                        orgnummer = "123456789",
                        orgnavn = "Mitt selskap Etternavn",
                    ),
                )
            val result =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .post("/api/v1/roller")
                            .header("Authorization", "Bearer ${oauthServer.skapAzureJwt()}")
                            .content("""{"fnr":"11111111111"}""")
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val rollerDto: RollerDto = objectMapper.readValue(result)
            val roller = rollerDto.roller
            roller.size `should be equal to` 1
            roller.first().let {
                it.rolletype `should be equal to` Rolletype.INNH
                it.organisasjonsnavn `should be equal to` "Mitt selskap Etternavn"
                it.organisasjonsnummer `should be equal to` "123456789"
            }
        }

        @Test
        fun `burde returnere roller`() {
            brregClient.roller = listOf(lagRolle(), lagRolle())

            val result =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .post("/api/v1/roller")
                            .header("Authorization", "Bearer ${oauthServer.skapAzureJwt()}")
                            .content("""{"fnr":"11111111111"}""")
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val rollerDto: RollerDto = objectMapper.readValue(result)
            val roller = rollerDto.roller
            roller.size `should be equal to` 2
        }

        @Test
        fun `burde kun returnere rolletyper som er spesifisert`() {
            brregClient.roller =
                listOf(
                    lagRolle(rolletype = Rolletype.DAGL),
                    lagRolle(rolletype = Rolletype.INNH),
                )

            val filtrerRolletyper = listOf(Rolletype.INNH)

            val result =
                mockMvc
                    .perform(
                        MockMvcRequestBuilders
                            .post("/api/v1/roller")
                            .header("Authorization", "Bearer ${oauthServer.skapAzureJwt()}")
                            .content(HentRollerRequest(fnr = "11111111111", rolleTyper = filtrerRolletyper).serialisertTilString())
                            .contentType(MediaType.APPLICATION_JSON),
                    ).andExpect(MockMvcResultMatchers.status().isOk)
                    .andReturn()
                    .response.contentAsString

            val rollerDto: RollerDto = objectMapper.readValue(result)
            val roller = rollerDto.roller
            roller.size `should be equal to` 1
            roller.first().rolletype `should be equal to` Rolletype.INNH
        }

        @Test
        fun `burde returnere NOT_FOUND ved brreg NOT_FOUND`() {
            brregClient.hentRollerException = BrregClientException(message = "", httpStatus = HttpStatus.NOT_FOUND.value())

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

        @Test
        fun `burde returnere BAD_GATEWAY ved Brreg server exception`() {
            brregClient.hentRollerException = BrregServerException(message = "")

            val token = oauthServer.skapAzureJwt()

            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .post("/api/v1/roller")
                        .header("Authorization", "Bearer $token")
                        .content("""{"fnr":"00000000000"}""")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isBadGateway)
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
