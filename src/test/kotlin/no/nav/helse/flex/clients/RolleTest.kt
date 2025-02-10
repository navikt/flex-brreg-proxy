package no.nav.helse.flex.clients

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class RolleTest {
    enum class RolletypeParam(
        val beskrivelse: String,
        val rolletype: Rolletype,
    ) {
        ADOS("Administrativ enhet - offentlig sektor", Rolletype.ADOS),
        BEST("Bestyrende reder", Rolletype.BEST),
        BOBE("Bostyrer", Rolletype.BOBE),
        DAGL_1("Daglig leder", Rolletype.DAGL),
        DAGL_2("Daglig leder/ adm.direktør", Rolletype.DAGL),
        DAGL_3("Dagleg leiar/ adm.direktør", Rolletype.DAGL),
        DTPR_1("Deltaker med proratarisk ansvar (delt ansvar)", Rolletype.DTPR),
        DTPR_2("Deltaker med delt ansvar", Rolletype.DTPR),
        DTSO_1("Deltaker med solidarisk ansvar (fullt ansvarlig)", Rolletype.DTSO),
        DTSO_2("Deltaker med fullt ansvar", Rolletype.DTSO),
        EIKM("Eierkommune", Rolletype.EIKM),
        FFØR_1("Forretningsfører", Rolletype.FFØR),
        FFØR_2("Forretningsførar", Rolletype.FFØR),
        HFOR("Opplysninger om foretaket i hjemlandet", Rolletype.HFOR),
        HLSE("Helseforetak", Rolletype.HLSE),
        INNH_1("Innehaver", Rolletype.INNH),
        INNH_2("Innehavar", Rolletype.INNH),
        KDEB("Konkursdebitor", Rolletype.KDEB),
        KENK("Den personlige konkursen angår", Rolletype.KENK),
        KIRK("Inngår i kirkelig fellesråd", Rolletype.KIRK),
        KOMP("Komplementar", Rolletype.KOMP),
        KONT("Kontaktperson", Rolletype.KONT),
        KTRF("Inngår i kontorfellesskap", Rolletype.KTRF),
        LEDE_1("Styrets leder", Rolletype.LEDE),
        LEDE_2("Styreleiar", Rolletype.LEDE),
        MEDL("Styremedlem", Rolletype.MEDL),
        NEST_1("Nestleder", Rolletype.NEST),
        NEST_2("Nestleiar", Rolletype.NEST),
        OBS("Observatør", Rolletype.OBS),
        OPMV("er særskilt oppdelt enhet til", Rolletype.OPMV),
        ORGL("Organisasjonsledd i offentlig sektor", Rolletype.ORGL),
        POFE("Prokura i fellesskap", Rolletype.POFE),
        POHV_1("Prokura hver for seg", Rolletype.POHV),
        POHV_2("Prokura kvar for seg", Rolletype.POHV),
        PROK("Prokura", Rolletype.PROK),
        REGN_1("Regnskapsfører", Rolletype.REGN),
        REGN_2("Rekneskapsførar", Rolletype.REGN),
        REPR_1("Norsk representant for utenlandsk enhet", Rolletype.REPR),
        REPR_2("Norsk repr. for utenl. enhet", Rolletype.REPR),
        REVI("Revisor", Rolletype.REVI),
        SIHV("Signatur hver for seg", Rolletype.SIHV),
        SIFE("Signatur i fellesskap", Rolletype.SIFE),
        SIGN("Signatur", Rolletype.SIGN),
        VARA("Varamedlem", Rolletype.VARA),
    }

    @ParameterizedTest
    @EnumSource(RolletypeParam::class)
    fun `burde mappe rolletyper`(rolletypeParam: RolletypeParam) {
        Rolletype.Companion.fromBeskrivelse(rolletypeParam.beskrivelse) `should be equal to` rolletypeParam.rolletype
    }

    @Test
    fun `burde mappe rolletype til ukjent ved alle andre beskrivelser`() {
        Rolletype.Companion.fromBeskrivelse("tilfeldig beskrivelse") `should be equal to` Rolletype.UKJENT
    }
}
