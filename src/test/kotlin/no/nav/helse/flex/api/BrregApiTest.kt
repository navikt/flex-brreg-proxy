package no.nav.helse.flex.api

import no.nav.helse.flex.clients.BrregStatus
import no.nav.helse.flex.testoppsett.ApiTestOppsett
import no.nav.helse.flex.testoppsett.BrregClientFake
import no.nav.helse.flex.testoppsett.FakesTestOppsett
import no.nav.helse.flex.testoppsett.FellesTestOppsett
import no.nav.security.mock.oauth2.MockOAuth2Server
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@FakesTestOppsett
@FellesTestOppsett
@ApiTestOppsett
class BrregApiTest {
    @Autowired
    lateinit var brregClient: BrregClientFake

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var oauthServer: MockOAuth2Server

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
}
