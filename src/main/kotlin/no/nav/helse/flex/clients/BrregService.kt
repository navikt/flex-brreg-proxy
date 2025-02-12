package no.nav.helse.flex.clients

import no.nav.helse.flex.config.logger
import org.springframework.stereotype.Component

@Component
class BrregService(
    private val brregClient: BrregClient,
) {
    private val log = logger()

    fun hentResponsStatus(): BrregStatus = brregClient.hentStatus()

    fun hentRoller(
        fnr: String,
        rolleTyper: List<Rolletype>? = null,
    ): List<Rolle> {
        val roller = brregClient.hentRoller(fnr)
        return if (rolleTyper != null) {
            roller.filter { it.rolletype in rolleTyper }
        } else {
            roller
        }
    }
}
