package no.nav.helse.flex.testoppsett

import no.nav.helse.flex.clients.BrregClient
import no.nav.helse.flex.clients.BrregStatus
import no.nav.helse.flex.clients.RolleDto
import no.nav.security.token.support.client.spring.oauth2.EnableOAuth2Client
import no.nav.security.token.support.spring.api.EnableJwtTokenValidation
import no.nav.security.token.support.spring.test.EnableMockOAuth2Server
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.test.context.TestPropertySource

@MockServerTestOppsett
@EnableMockOAuth2Server
@EnableOAuth2Client
@EnableJwtTokenValidation
@TestPropertySource(
    properties = [
        "spring.profiles.active=dev",
    ],
)
annotation class BrregStubClientOppsett

@TestPropertySource(
    properties = [
        "spring.profiles.active=brreg-mock",
    ],
)
annotation class BrregMockClientOppsett

@MockServerTestOppsett
@TestPropertySource(
    properties = [
        "spring.profiles.active=prod",
    ],
)
annotation class BrregSoapClientOppsett

@Import(BrregClientFakesConfig::class)
annotation class BrregClientFakesOppsett

@TestConfiguration
class BrregClientFakesConfig {
    @Bean
    fun brregClient() = BrregClientFake()
}

class BrregClientFake : BrregClient {
    var roller: List<RolleDto> = emptyList()
    var status: BrregStatus = BrregStatus("OK", true, HttpStatus.OK)
    var hentRollerException: Exception? = null
    var hentStatusException: Exception? = null

    override fun hentRoller(fnr: String) = hentRollerException?.let { throw it } ?: roller

    override fun hentStatus() = hentStatusException?.let { throw it } ?: status

    fun clear() {
        roller = emptyList()
        status = BrregStatus("OK", true, HttpStatus.OK)
        hentRollerException = null
        hentStatusException = null
    }
}
