package no.nav.helse.flex

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@TestPropertySource(
    properties = [
        "spring.profiles.active=prod",
    ],
)
class ApplicationTest : FellesTestOppsett() {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/internal/health"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("UP"))
    }
}
