package no.nav.helse.flex

import no.nav.helse.flex.testoppsett.ApiTestOppsett
import no.nav.helse.flex.testoppsett.FellesTestOppsett
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@FellesTestOppsett
@TestPropertySource(properties = ["spring.profiles.active=default"])
@ApiTestOppsett
@TestPropertySource(
    properties = [
        "spring.profiles.active=prod",
    ],
)
class ApplicationTest {
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
