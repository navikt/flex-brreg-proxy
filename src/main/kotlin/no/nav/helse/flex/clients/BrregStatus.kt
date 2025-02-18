package no.nav.helse.flex.clients

data class BrregStatus(
    val melding: String,
    val erOk: Boolean,
) {
    fun anonymisertMelding() = melding.replace("\\d{11}".toRegex(), "X".repeat(11))
}
