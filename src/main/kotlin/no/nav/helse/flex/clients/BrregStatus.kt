package no.nav.helse.flex.clients

import generated.roller.Grunndata as RollerGrunndata
import generated.rolleutskrift.Grunndata as RolleutskriftGrunndata

data class BrregStatus(
    val hovedStatus: Int,
    val underStatuser: List<UnderStatus>,
) {
    fun erOk() = hovedStatus == 0

    fun somTekst(): String {
        val underStatusMelding = underStatuser.joinToString(", ") { "${it.underStatus}: ${it.melding}" }
        return "hovedStatus: $hovedStatus, underStatuser: $underStatusMelding"
    }

    fun somAnonymisertTekst(): String = somTekst().anonymiserFnr()

    data class UnderStatus(
        val underStatus: Int,
        val melding: String,
    )

    companion object {
        fun fraResponseHeader(responseHeader: RolleutskriftGrunndata.ResponseHeader): BrregStatus =
            BrregStatus(
                hovedStatus = responseHeader.hovedStatus,
                underStatuser =
                    responseHeader.underStatus.underStatusMelding.map {
                        UnderStatus(
                            underStatus = it.kode,
                            melding = it.value,
                        )
                    },
            )

        fun fraResponseHeader(responseHeader: RollerGrunndata.ResponseHeader): BrregStatus =
            BrregStatus(
                hovedStatus = responseHeader.hovedStatus,
                underStatuser =
                    responseHeader.underStatus.underStatusMelding.map {
                        UnderStatus(
                            underStatus = it.kode,
                            melding = it.value,
                        )
                    },
            )

        internal fun String.anonymiserFnr(): String = this.replace("\\d{11}".toRegex(), "X".repeat(11))
    }
}
