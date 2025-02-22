package no.nav.helse.flex.clients

import org.springframework.context.annotation.Profile
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Profile("brreg-mock")
@Component
class BrregMockClient : BrregClient {
    override fun hentRoller(fnr: String): List<RolleDto> =
        listOf(
            RolleDto(
                Rolletype.INNH,
                organisasjonsnummer = "123456789",
                organisasjonsnavn = "Mitt Helt Eget Selskap",
            ),
        )

    override fun hentStatus(): BrregStatus = BrregStatus("OK", true, HttpStatus.OK)
}
