package no.nav.helse.flex.clients

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Profile("brreg-mock")
@Component
class BrregMockClient : BrregClient {
    override fun hentRoller(fnr: String): List<Rolle> =
        listOf(
            Rolle(
                Rolletype.INNH,
                orgnummer = "123456789",
                orgnavn = "Mitt Helt Eget Selskap",
            ),
        )

    override fun hentStatus(): BrregStatus = BrregStatus("OK", true)
}
