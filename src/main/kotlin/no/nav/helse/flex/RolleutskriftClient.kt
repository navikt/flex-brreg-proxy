package no.nav.helse.flex

import org.springframework.stereotype.Component

@Component
class RolleutskriftClient(
    private val brregSoapClient: BrregSoapClient,
) {
    fun hentRolleutskriftRaw(fnr: String): generated.rolleutskrift.Grunndata? = brregSoapClient.hentRolleutskrift(fnr = fnr)
}
