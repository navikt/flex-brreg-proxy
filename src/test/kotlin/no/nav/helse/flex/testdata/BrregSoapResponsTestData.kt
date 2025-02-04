package no.nav.helse.flex.testdata

fun lagRolleutskriftSoapRespons(fnr: String = "2020010199999"): String =
    """
    <?xml version="1.0"?>
    <grunndata xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:noNamespaceSchemaLocation="https://schema.brreg.no/grunndata/hentRolleutskrift.xsd">
       <responseHeader prossessDato="2020-04-20" tjeneste="hentRolleutskrift">
          <fodselsnr>$fnr</fodselsnr>
          <hovedStatus>0</hovedStatus>
          <underStatus>
             <underStatusMelding kode="0">Data returnert</underStatusMelding>
          </underStatus>
       </responseHeader>
       <melding tjeneste="hentRolleutskrift">
          <rolleInnehaver>
             <fodselsdato ledetekst="Fødselsdato">2000-01-01</fodselsdato>
             <navn ledetekst="Navn">
                <navn1>Navn</navn1>
                <navn3>Navnesen</navn3>
             </navn>
             <adresse ledetekst="Adresse">
                <adresse1>Syntveien 1</adresse1>
                <postnr>2020</postnr>
                <poststed>OSLO</poststed>
                <land landkode1="NO">Norge</land>
             </adresse>
          </rolleInnehaver>
          <roller ledetekst="Oversikt over innførte roller i Foretaksregisteret og innførte roller i tilknytning til næringsvirksomhet i Enhetsregisteret pr. 20.04.2020">
             <enhet nr="1" registreringsDato="2022-01-01">
                <rolleBeskrivelse ledetekst="Rolle">Innehaver</rolleBeskrivelse>
                <orgnr ledetekst="Organisasjonsnummer">995298775</orgnr>
                <navn ledetekst="Foretaksnavn">
                   <navn1>SELSKAP AS</navn1>
                </navn>
                <adresse>
                   <forretningsAdresse ledetekst="Forretningsadresse">
                      <adresse1>Dollyveien 1</adresse1>
                      <postnr>2020</postnr>
                      <poststed>OSLO</poststed>
                      <kommune kommnr="1010" ledetekst="Kommune">OSLO</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </forretningsAdresse>
                   <postAdresse ledetekst="Postadresse">
                      <adresse1>Postboks 3</adresse1>
                      <postnr>1337</postnr>
                      <poststed>DRAMMEN</poststed>
                      <kommune kommnr="1010" ledetekst="Kommune">DRAMMEN</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </postAdresse>
                </adresse>
             </enhet>
             <enhet nr="2" registreringsDato="2022-02-02">
                <rolleBeskrivelse ledetekst="Rolle">Deltaker med delt ansvar</rolleBeskrivelse>
                <orgnr ledetekst="Organisasjonsnummer">971524553</orgnr>
                <navn ledetekst="Foretaksnavn">
                   <navn1>DIDGERIDOO AS</navn1>
                </navn>
                <adresse>
                   <forretningsAdresse ledetekst="Forretningsadresse">
                      <adresse1>Gata 1</adresse1>
                      <postnr>2020</postnr>
                      <poststed>OSLO</poststed>
                      <kommune kommnr="1010" ledetekst="Kommune">OSLO</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </forretningsAdresse>
                   <postAdresse ledetekst="Postadresse">
                      <adresse1>Postboks 1</adresse1>
                      <postnr>1337</postnr>
                      <poststed>DRAMMEN</poststed>
                      <kommune kommnr="2020" ledetekst="Kommune">DRAMMEN</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </postAdresse>
                </adresse>
             </enhet>
             <enhet nr="3" registreringsDato="2019-01-01">
                <rolleBeskrivelse ledetekst="Rolle">Deltaker med fullt ansvar</rolleBeskrivelse>
                <orgnr ledetekst="Organisasjonsnummer">932805512</orgnr>
                <navn ledetekst="Foretaksnavn">
                   <navn1>ILA AS</navn1>
                </navn>
                <adresse>
                   <forretningsAdresse ledetekst="Forretningsadresse">
                      <adresse1>Veien 7</adresse1>
                      <postnr>7331</postnr>
                      <poststed>HOLM</poststed>
                      <kommune kommnr="1111" ledetekst="Kommune">HOLMEN</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </forretningsAdresse>
                   <postAdresse ledetekst="Postadresse">
                      <adresse1>Postboks 10</adresse1>
                      <postnr>7331</postnr>
                      <poststed>FOLM</poststed>
                      <kommune kommnr="1111" ledetekst="Kommune">HOLMEN</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </postAdresse>
                </adresse>
             </enhet>
             <enhet nr="4" registreringsDato="2021-09-09">
                <rolleBeskrivelse ledetekst="Rolle">Styremedlem</rolleBeskrivelse>
                <orgnr ledetekst="Organisasjonsnummer">974652269</orgnr>
                <navn ledetekst="Foretaksnavn">
                   <navn1>NAV Boretteslag</navn1>
                </navn>
                <adresse>
                   <forretningsAdresse ledetekst="Forretningsadresse">
                      <adresse1>Veien 7</adresse1>
                      <postnr>7331</postnr>
                      <poststed>HOLM</poststed>
                      <kommune kommnr="1111" ledetekst="Kommune">HOLMEN</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </forretningsAdresse>
                   <postAdresse ledetekst="Postadresse">
                      <adresse1>Postboks 10</adresse1>
                      <postnr>7331</postnr>
                      <poststed>FOLM</poststed>
                      <kommune kommnr="1111" ledetekst="Kommune">HOLMEN</kommune>
                      <land landkode1="NO" ledetekst="Land">Norge</land>
                   </postAdresse>
                </adresse>
             </enhet>
          </roller>
       </melding>
    </grunndata>
    """.trimIndent()
