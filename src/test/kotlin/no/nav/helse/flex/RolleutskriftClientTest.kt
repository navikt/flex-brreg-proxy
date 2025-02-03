package no.nav.helse.flex

import generated.rolleutskrift.Grunndata
import no.nav.helse.flex.config.serialisertTilString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RolleutskriftClientTest : FellesTestOppsett() {
    @Autowired
    lateinit var rolleutskriftClient: RolleutskriftClient

    init {
        System.setProperty("BRREG_USERNAME", "username")
        System.setProperty("BRREG_PASSWORD", "password")
        System.setProperty("BRREG_URL", "https://grunndata.brreg.no/grunndata/ErFr")
    }

    @Test
    fun `burde ikke autentisere`() {
        val res = rolleutskriftClient.hentRolleutskriftRaw("11111111111")
        println(res)
        println(res?.responseHeader?.toHeaderString())
        val meldingJson = res?.melding?.serialisertTilString()
        println(meldingJson)

        res
            ?.responseHeader
            ?.underStatus
            ?.underStatusMelding
            ?.any { it.kode == -101 }
    }
}

private fun Grunndata.ResponseHeader.toHeaderString(): String {
    val understatuser = this.underStatus?.underStatusMelding?.joinToString(", ") { "${it.kode}: ${it.value}" }
    return "ResponseHeader(" +
        "requestId=$requestID, " +
        "hovedStatus=$hovedStatus, " +
        "underStatusMeldinger=$understatuser, " +
        "orgnr=${this.orgnr}, " +
        "tjeneste=${this.tjeneste})"
}
