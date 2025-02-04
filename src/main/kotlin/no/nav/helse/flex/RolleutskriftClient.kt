package no.nav.helse.flex

import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component

@Component
class RolleutskriftClient(
    private val brregSoapClient: BrregSoapClient,
) {
    @Retryable(include = [Exception::class], maxAttempts = 3, backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"))
    fun hentRolleutskriftRaw(fnr: String): generated.rolleutskrift.Grunndata? = brregSoapClient.hentRolleutskrift(fnr = fnr)
}
