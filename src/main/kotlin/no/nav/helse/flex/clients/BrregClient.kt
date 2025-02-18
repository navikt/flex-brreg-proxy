package no.nav.helse.flex.clients

interface BrregClient {
    fun hentRoller(fnr: String): List<RolleDto>

    fun hentStatus(): BrregStatus
}
