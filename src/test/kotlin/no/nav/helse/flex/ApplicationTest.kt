package no.nav.helse.flex

import no.nav.helse.flex.testoppsett.FellesTestOppsett
import no.nav.security.token.support.spring.test.EnableMockOAuth2Server
import org.junit.jupiter.api.Test
import org.springframework.test.context.TestPropertySource

@EnableMockOAuth2Server
@FellesTestOppsett
@TestPropertySource(properties = ["spring.profiles.active=default, prod"])
class ApplicationTest {
    @Test
    fun contextLoads() {
    }
}
