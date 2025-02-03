package no.nav.helse.flex

import generated.rolleutskrift.Grunndata
import no.nav.helse.flex.config.logger
import no.nav.helse.flex.config.serialisertTilString
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Profile("disabled")
@Component
class BrregScheduledCaller(
    private val rolleutskriftClient: RolleutskriftClient,
) {
    private val log = logger()

    @Scheduled(initialDelay = 1, fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    fun callBrreg() {
        log.info("Kaller på brreg")
        val res = rolleutskriftClient.hentRolleutskriftRaw("04817797240")
        log.info(res?.responseHeader?.toHeaderString())
        try {
            log.info(res?.serialisertTilString())
            val meldingJson = res?.melding?.serialisertTilString()
            log.info(meldingJson)
        } catch (e: Exception) {
            log.error("Failed to serialize response", e)
        }
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
