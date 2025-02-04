package no.nav.helse.flex.testdata

fun lagRolleutskriftSoapRespons(fnr: String = "2020010199999"): String =
    """
&lt;?xml version="1.0"?&gt;
&lt;grunndata xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="https://schema.brreg.no/grunndata/hentRolleutskrift.xsd"&gt;
   &lt;responseHeader prossessDato="2020-04-20" tjeneste="hentRolleutskrift"&gt;
      &lt;fodselsnr&gt;$fnr&lt;/fodselsnr&gt;
      &lt;hovedStatus&gt;0&lt;/hovedStatus&gt;
      &lt;underStatus&gt;
         &lt;underStatusMelding kode="0"&gt;Data returnert&lt;/underStatusMelding&gt;
      &lt;/underStatus&gt;
   &lt;/responseHeader&gt;
   &lt;melding tjeneste="hentRolleutskrift"&gt;
      &lt;rolleInnehaver&gt;
         &lt;fodselsdato ledetekst="Fødselsdato"&gt;2000-01-01&lt;/fodselsdato&gt;
         &lt;navn ledetekst="Navn"&gt;
            &lt;navn1&gt;Navn&lt;/navn1&gt;
            &lt;navn3&gt;Navnesen&lt;/navn3&gt;
         &lt;/navn&gt;
         &lt;adresse ledetekst="Adresse"&gt;
            &lt;adresse1&gt;Syntveien 1&lt;/adresse1&gt;
            &lt;postnr&gt;2020&lt;/postnr&gt;
            &lt;poststed&gt;OSLO&lt;/poststed&gt;
            &lt;land landkode1="NO"&gt;Norge&lt;/land&gt;
         &lt;/adresse&gt;
      &lt;/rolleInnehaver&gt;
      &lt;roller ledetekst="Oversikt over innførte roller i Foretaksregisteret og innførte roller i tilknytning til næringsvirksomhet i Enhetsregisteret pr. 20.04.2020"&gt;
         &lt;enhet nr="1" registreringsDato="2022-01-01"&gt;
            &lt;rolleBeskrivelse ledetekst="Rolle"&gt;Innehaver&lt;/rolleBeskrivelse&gt;
            &lt;orgnr ledetekst="Organisasjonsnummer"&gt;995298775&lt;/orgnr&gt;
            &lt;navn ledetekst="Foretaksnavn"&gt;
               &lt;navn1&gt;SELSKAP AS&lt;/navn1&gt;
            &lt;/navn&gt;
            &lt;adresse&gt;
               &lt;forretningsAdresse ledetekst="Forretningsadresse"&gt;
                  &lt;adresse1&gt;Dollyveien 1&lt;/adresse1&gt;
                  &lt;postnr&gt;2020&lt;/postnr&gt;
                  &lt;poststed&gt;OSLO&lt;/poststed&gt;
                  &lt;kommune kommnr="1010" ledetekst="Kommune"&gt;OSLO&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/forretningsAdresse&gt;
               &lt;postAdresse ledetekst="Postadresse"&gt;
                  &lt;adresse1&gt;Postboks 3&lt;/adresse1&gt;
                  &lt;postnr&gt;1337&lt;/postnr&gt;
                  &lt;poststed&gt;DRAMMEN&lt;/poststed&gt;
                  &lt;kommune kommnr="1010" ledetekst="Kommune"&gt;DRAMMEN&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/postAdresse&gt;
            &lt;/adresse&gt;
         &lt;/enhet&gt;
         &lt;enhet nr="2" registreringsDato="2022-02-02"&gt;
            &lt;rolleBeskrivelse ledetekst="Rolle"&gt;Deltaker med delt ansvar&lt;/rolleBeskrivelse&gt;
            &lt;orgnr ledetekst="Organisasjonsnummer"&gt;971524553&lt;/orgnr&gt;
            &lt;navn ledetekst="Foretaksnavn"&gt;
               &lt;navn1&gt;DIDGERIDOO AS&lt;/navn1&gt;
            &lt;/navn&gt;
            &lt;adresse&gt;
               &lt;forretningsAdresse ledetekst="Forretningsadresse"&gt;
                  &lt;adresse1&gt;Gata 1&lt;/adresse1&gt;
                  &lt;postnr&gt;2020&lt;/postnr&gt;
                  &lt;poststed&gt;OSLO&lt;/poststed&gt;
                  &lt;kommune kommnr="1010" ledetekst="Kommune"&gt;OSLO&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/forretningsAdresse&gt;
               &lt;postAdresse ledetekst="Postadresse"&gt;
                  &lt;adresse1&gt;Postboks 1&lt;/adresse1&gt;
                  &lt;postnr&gt;1337&lt;/postnr&gt;
                  &lt;poststed&gt;DRAMMEN&lt;/poststed&gt;
                  &lt;kommune kommnr="2020" ledetekst="Kommune"&gt;DRAMMEN&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/postAdresse&gt;
            &lt;/adresse&gt;
         &lt;/enhet&gt;
         &lt;enhet nr="3" registreringsDato="2019-01-01"&gt;
            &lt;rolleBeskrivelse ledetekst="Rolle"&gt;Deltaker med fullt ansvar&lt;/rolleBeskrivelse&gt;
            &lt;orgnr ledetekst="Organisasjonsnummer"&gt;932805512&lt;/orgnr&gt;
            &lt;navn ledetekst="Foretaksnavn"&gt;
               &lt;navn1&gt;ILA AS&lt;/navn1&gt;
            &lt;/navn&gt;
            &lt;adresse&gt;
               &lt;forretningsAdresse ledetekst="Forretningsadresse"&gt;
                  &lt;adresse1&gt;Veien 7&lt;/adresse1&gt;
                  &lt;postnr&gt;7331&lt;/postnr&gt;
                  &lt;poststed&gt;HOLM&lt;/poststed&gt;
                  &lt;kommune kommnr="1111" ledetekst="Kommune"&gt;HOLMEN&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/forretningsAdresse&gt;
               &lt;postAdresse ledetekst="Postadresse"&gt;
                  &lt;adresse1&gt;Postboks 10&lt;/adresse1&gt;
                  &lt;postnr&gt;7331&lt;/postnr&gt;
                  &lt;poststed&gt;FOLM&lt;/poststed&gt;
                  &lt;kommune kommnr="1111" ledetekst="Kommune"&gt;HOLMEN&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/postAdresse&gt;
            &lt;/adresse&gt;
         &lt;/enhet&gt;
         &lt;enhet nr="4" registreringsDato="2021-09-09"&gt;
            &lt;rolleBeskrivelse ledetekst="Rolle"&gt;Styremedlem&lt;/rolleBeskrivelse&gt;
            &lt;orgnr ledetekst="Organisasjonsnummer"&gt;974652269&lt;/orgnr&gt;
            &lt;navn ledetekst="Foretaksnavn"&gt;
               &lt;navn1&gt;NAV Boretteslag&lt;/navn1&gt;
            &lt;/navn&gt;
            &lt;adresse&gt;
               &lt;forretningsAdresse ledetekst="Forretningsadresse"&gt;
                  &lt;adresse1&gt;Veien 7&lt;/adresse1&gt;
                  &lt;postnr&gt;7331&lt;/postnr&gt;
                  &lt;poststed&gt;HOLM&lt;/poststed&gt;
                  &lt;kommune kommnr="1111" ledetekst="Kommune"&gt;HOLMEN&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/forretningsAdresse&gt;
               &lt;postAdresse ledetekst="Postadresse"&gt;
                  &lt;adresse1&gt;Postboks 10&lt;/adresse1&gt;
                  &lt;postnr&gt;7331&lt;/postnr&gt;
                  &lt;poststed&gt;FOLM&lt;/poststed&gt;
                  &lt;kommune kommnr="1111" ledetekst="Kommune"&gt;HOLMEN&lt;/kommune&gt;
                  &lt;land landkode1="NO" ledetekst="Land"&gt;Norge&lt;/land&gt;
               &lt;/postAdresse&gt;
            &lt;/adresse&gt;
         &lt;/enhet&gt;
      &lt;/roller&gt;
   &lt;/melding&gt;
&lt;/grunndata&gt;
    """.trimIndent().wrapWithXmlEnvelope()

private fun String.wrapWithXmlEnvelope(): String =
    """
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">

<soap:Body>

    <hentRolleutskriftResponse xmlns="http://no/brreg/saksys/grunndata/ws">
        <return>$this
        </return>
    </hentRolleutskriftResponse>

</soap:Body>

</soap:Envelope>
    """.trimIndent()
