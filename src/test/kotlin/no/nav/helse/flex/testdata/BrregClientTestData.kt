package no.nav.helse.flex.testdata

import no.nav.helse.flex.clients.Rolle
import no.nav.helse.flex.clients.Rolletype

fun lagRolle(
    rolletype: Rolletype = Rolletype.INNH,
    orgnummer: String = "123456789",
    orgnavn: String = "Mitt selskap Etternavn",
): Rolle =
    Rolle(
        rolletype = rolletype,
        orgnummer = orgnummer,
        orgnavn = orgnavn,
    )
