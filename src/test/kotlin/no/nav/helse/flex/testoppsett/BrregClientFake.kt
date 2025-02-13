package no.nav.helse.flex.testoppsett

import no.nav.helse.flex.clients.BrregClient
import no.nav.helse.flex.clients.BrregStatus
import no.nav.helse.flex.clients.Rolle
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

class BrregClientFake : BrregClient {
    var roller: List<Rolle> = emptyList()
    var status: BrregStatus = BrregStatus("OK", true)

    override fun hentRoller(fnr: String) = roller

    override fun hentStatus() = status

    fun clear() {
        roller = emptyList()
        status = BrregStatus("OK", true)
    }
}

@Import(FakesConfig::class)
annotation class FakesTestOppsett

@TestConfiguration
class FakesConfig {
    @Bean
    fun brregClient() = BrregClientFake()
}
