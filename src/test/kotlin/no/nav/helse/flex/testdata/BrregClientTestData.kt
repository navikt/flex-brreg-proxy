package no.nav.helse.flex.testdata

import no.nav.helse.flex.clients.RolleDto
import no.nav.helse.flex.clients.Rolletype

fun lagRolle(
    rolletype: Rolletype = Rolletype.INNH,
    orgnummer: String = "123456789",
    orgnavn: String = "Mitt selskap Etternavn",
): RolleDto =
    RolleDto(
        rolletype = rolletype,
        organisasjonsnummer = orgnummer,
        organisasjonsnavn = orgnavn,
    )
