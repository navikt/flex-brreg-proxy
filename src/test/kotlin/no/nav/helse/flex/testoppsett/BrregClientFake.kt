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
    var hentRollerException: Exception? = null
    var hentStatusException: Exception? = null

    override fun hentRoller(fnr: String) = hentRollerException?.let { throw it } ?: roller

    override fun hentStatus() = hentStatusException?.let { throw it } ?: status

    fun clear() {
        roller = emptyList()
        status = BrregStatus("OK", true)
        hentRollerException = null
        hentStatusException = null
    }
}

@Import(BrregClientFakesConfig::class)
annotation class BrregClientFakesOppsett

@TestConfiguration
class BrregClientFakesConfig {
    @Bean
    fun brregClient() = BrregClientFake()
}
