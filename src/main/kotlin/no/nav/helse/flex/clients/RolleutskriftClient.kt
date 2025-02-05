package no.nav.helse.flex.clients

import no.nav.helse.flex.api.Rolle
import no.nav.helse.flex.api.RolleType
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component

@Component
class RolleutskriftClient(
    private val brregSoapClient: BrregSoapClient,
) {
    @Retryable(
        include = [SoapServiceException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    fun hentRolleutskriftRaw(fnr: String): generated.rolleutskrift.Grunndata = brregSoapClient.hentRolleutskrift(fnr = fnr)

    @Retryable(
        include = [SoapServiceException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    fun hentRoller(
        fnr: String,
        rolleTyper: List<RolleType>? = null,
    ): List<Rolle> {
        val grunndata = brregSoapClient.hentRolleutskrift(fnr = fnr)
        return grunndata.melding.roller.enhet
            .map {
                Rolle(
                    rolleType = RolleType.fromBeskrivelse(it.rolleBeskrivelse.value),
                    organisasjonsnummer = it.orgnr.value.toString(),
                )
            }.filter { it.rolleType in (rolleTyper ?: RolleType.entries.toList()) }
    }
}
