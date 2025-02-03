package no.nav.helse.flex

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class ApiTest : FellesTestOppsett() {
    @Test
    fun `burde ikke ha tilgang til brreg`() {
        val result =
            mockMvc
                .perform(
                    MockMvcRequestBuilders
                        .get("/api/v1/check-brreg-auth")
                        .contentType(MediaType.APPLICATION_JSON),
                ).andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
                .response.contentAsString

        result `should be equal to` "false"
    }
}
