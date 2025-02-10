package no.nav.helse.flex.clients

import no.nav.helse.flex.config.logger
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component

@Component
class BrregService(
    private val brregSoapClient: BrregSoapClient,
) {
    private val log = logger()

    @Retryable(
        include = [SoapServiceException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    fun hentResponsStatus(): BrregStatus {
        val navOrgnummerForSjekk = "889640782"
        val grunndata = brregSoapClient.hentRoller(orgnummer = navOrgnummerForSjekk)

        return BrregStatus(
            hovedStatus = grunndata.responseHeader.hovedStatus,
            underStatuser =
                grunndata.responseHeader.underStatus.underStatusMelding.map {
                    BrregStatus.UnderStatus(
                        underStatus = it.kode,
                        melding = it.value,
                    )
                },
        )
    }

    @Retryable(
        include = [SoapServiceException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    fun hentRoller(
        fnr: String,
        rolleTyper: List<Rolletype>? = null,
    ): List<Rolle> {
        val grunndata = brregSoapClient.hentRolleutskrift(fnr = fnr)
        return grunndata.melding.roller.enhet
            .map {
                val rolle =
                    Rolle(
                        rolletype = Rolletype.fromBeskrivelse(it.rolleBeskrivelse.value),
                        orgnummer = it.orgnr.value.toString(),
                        orgnavn = it.navn.navn1,
                    )
                if (rolle.rolletype == Rolletype.UKJENT) {
                    log.warn("Ukjent rolletype: ${it.rolleBeskrivelse.value}")
                }
                rolle
            }.filter { it.rolletype in (rolleTyper ?: Rolletype.entries.toList()) }
    }
}

data class BrregStatus(
    val hovedStatus: Int,
    val underStatuser: List<UnderStatus>,
) {
    fun erOk() = hovedStatus == 0

    data class UnderStatus(
        val underStatus: Int,
        val melding: String,
    )
}
