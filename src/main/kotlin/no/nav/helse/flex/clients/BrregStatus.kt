package no.nav.helse.flex.clients

import org.springframework.http.HttpStatus

data class BrregStatus(
    val melding: String,
    val erOk: Boolean,
    val httpStatus: HttpStatus? = null,
) {
    fun anonymisertMelding() = melding.replace("\\d{11}".toRegex(), "X".repeat(11))
}
