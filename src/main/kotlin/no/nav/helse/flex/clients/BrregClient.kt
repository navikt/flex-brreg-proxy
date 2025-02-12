package no.nav.helse.flex.clients

interface BrregClient {
    fun hentRoller(
        fnr: String,
        rolletyper: List<Rolletype>,
    ): List<Rolle>

    fun hentStatus(): BrregStatus
}
