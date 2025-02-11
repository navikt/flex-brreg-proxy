package no.nav.helse.flex.testdata

fun lagRolleutskriftSoapRespons(
    fnr: String = "2020010199999",
    headerHovedStatus: Int = 0,
): String =
    wrapWithRolleutskriftXmlEnvelope(
        """
        &lt;?xml version="1.0"?&gt;
        &lt;grunndata xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="https://schema.brreg.no/grunndata/hentRolleutskrift.xsd"&gt;
           &lt;responseHeader prossessDato="2020-04-20" tjeneste="hentRolleutskrift"&gt;
              &lt;fodselsnr&gt;$fnr&lt;/fodselsnr&gt;
              &lt;hovedStatus&gt;$headerHovedStatus&lt;/hovedStatus&gt;
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
        """.trimIndent(),
    )

fun lagRolleutskriftErrorSoapRespons(headerHovedStatus: Int = 0): String =
    wrapWithRolleutskriftXmlEnvelope(
        """
        &lt;?xml version="1.0"?&gt;
        &lt;grunndata xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="https://schema.brreg.no/grunndata/hentRolleutskrift.xsd"&gt;
           &lt;responseHeader prossessDato="2020-04-20" tjeneste="hentRolleutskrift"&gt;
              &lt;fodselsnr&gt;00000000000&lt;/fodselsnr&gt;
              &lt;hovedStatus&gt;$headerHovedStatus&lt;/hovedStatus&gt;
              &lt;underStatus&gt;
                 &lt;underStatusMelding kode="-200"&gt;Test feil&lt;/underStatusMelding&gt;
              &lt;/underStatus&gt;
           &lt;/responseHeader&gt;
           &lt;melding tjeneste="hentRolleutskrift"/&gt;
        &lt;/grunndata&gt;
        """.trimIndent(),
    )

fun lagRollerSoapResponse(
    orgnummer: String = "971524553",
    headerHovedStatus: Int = 0,
): String =
    wrapWithRollerXmlEnvelope(
        """
        &lt;?xml version=&quot;1.0&quot;?&gt;
        &lt;grunndata xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot; xsi:noNamespaceSchemaLocation=&quot;http://ftp2.brreg.no/xml/skjema/grunndata/2007/12/17/hentRoller.xsd&quot;&gt;
            &lt;responseHeader prossessDato=&quot;2019-03-21&quot; tjeneste=&quot;hentRoller&quot;&gt;
                &lt;orgnr&gt;$orgnummer&lt;/orgnr&gt;
                &lt;hovedStatus&gt;$headerHovedStatus&lt;/hovedStatus&gt;
                &lt;underStatus&gt;
                    &lt;underStatusMelding kode=&quot;0&quot;&gt;Data returnert&lt;/underStatusMelding&gt;
                    &lt;underStatusMelding kode=&quot;1180&quot;&gt;Enhet 971524553 har ikke Rolleblokk 2&lt;/underStatusMelding&gt;
                &lt;/underStatus&gt;
            &lt;/responseHeader&gt;
            &lt;melding tjeneste=&quot;hentRoller&quot;&gt;
                &lt;organisasjonsnummer registreringsDato=&quot;1999-03-12&quot;&gt;971524553&lt;/organisasjonsnummer&gt;
                &lt;kontaktperson&gt;
                    &lt;samendring beskrivelse=&quot;Daglig leder/ adm.direkt&amp;#xf8;r&quot; registreringsDato=&quot;2019-06-23&quot; samendringstype=&quot;DAGL&quot;&gt;
                        &lt;rolle beskrivelse=&quot;Daglig leder/ adm.direkt&amp;#xf8;r&quot; rolletype=&quot;DAGL&quot;&gt;
                            &lt;person beskrivelse=&quot;Lever&quot; statuskode=&quot;L&quot;&gt;
                                &lt;fodselsnr&gt;11111111111&lt;/fodselsnr&gt;
                                &lt;fornavn&gt;Daglig&lt;/fornavn&gt;
                                &lt;slektsnavn&gt;Daligsen&lt;/slektsnavn&gt;
                                &lt;adresse1&gt;Dagligveien 12&lt;/adresse1&gt;
                                &lt;adresse2&gt;Borti Lia&lt;/adresse2&gt;
                                &lt;adresse3&gt;Langt oppi der&lt;/adresse3&gt;
                                &lt;postnr&gt;9999&lt;/postnr&gt;
                                &lt;poststed&gt;OSLO&lt;/poststed&gt;
                                &lt;land landkode4=&quot;NOR&quot;&gt;Norge&lt;/land&gt;
                                &lt;fratraadt&gt;N&lt;/fratraadt&gt;
                            &lt;/person&gt;
                        &lt;/rolle&gt;
                    &lt;/samendring&gt;
                &lt;/kontaktperson&gt;
                &lt;styre&gt;
                    &lt;samendring beskrivelse=&quot;Styre&quot; registreringsDato=&quot;2019-11-18&quot; samendringstype=&quot;STYR&quot;&gt;
                        &lt;rolle beskrivelse=&quot;Styrets leder&quot; rolletype=&quot;LEDE&quot;&gt;
                            &lt;person beskrivelse=&quot;Lever&quot; statuskode=&quot;L&quot;&gt;
                                &lt;fodselsnr&gt;22222222222&lt;/fodselsnr&gt;
                                &lt;fornavn&gt;Leder&lt;/fornavn&gt;
                                &lt;slektsnavn&gt;Ledersen&lt;/slektsnavn&gt;
                                &lt;adresse1&gt;Styrelederveien 39&lt;/adresse1&gt;
                                &lt;postnr&gt;8888&lt;/postnr&gt;
                                &lt;poststed&gt;OSLO&lt;/poststed&gt;
                                &lt;land landkode4=&quot;NOR&quot;&gt;Norge&lt;/land&gt;
                                &lt;fratraadt&gt;N&lt;/fratraadt&gt;
                            &lt;/person&gt;
                        &lt;/rolle&gt;
                    &lt;/samendring&gt;
                &lt;/styre&gt;
                &lt;revisor&gt;
                    &lt;samendring beskrivelse=&quot;Revisor&quot; registreringsDato=&quot;1998-12-09&quot; samendringstype=&quot;REVI&quot;&gt;
                        &lt;rolle beskrivelse=&quot;Revisor&quot; rolletype=&quot;REVI&quot;&gt;
                            &lt;enhet beskrivelse=&quot;Normal&quot; statuskode=&quot;OK&quot;&gt;
                                &lt;orgnr&gt;000000001&lt;/orgnr&gt;
                                &lt;navn1&gt;Mock AS&lt;/navn1&gt;
                                &lt;adresse1&gt;Mock gate 14&lt;/adresse1&gt;
                                &lt;postnr&gt;0001&lt;/postnr&gt;
                                &lt;poststed&gt;OSLO&lt;/poststed&gt;
                                &lt;land landkode4=&quot;NOR&quot;&gt;Norge&lt;/land&gt;
                                &lt;fratraadt&gt;N&lt;/fratraadt&gt;
                                &lt;revisorKategori&gt;400&lt;/revisorKategori&gt;
                                &lt;revisorRkode&gt;5&lt;/revisorRkode&gt;
                                &lt;reTekst&gt;Godkjent revisjonsselskap&lt;/reTekst&gt;
                            &lt;/enhet&gt;
                        &lt;/rolle&gt;
                    &lt;/samendring&gt;
                &lt;/revisor&gt;
                &lt;regnskapsfoerer&gt;
                    &lt;samendring beskrivelse=&quot;Regnskapsf&amp;#xf8;rer&quot; registreringsDato=&quot;2012-01-17&quot; samendringstype=&quot;REGN&quot;&gt;
                        &lt;rolle beskrivelse=&quot;Regnskapsf&amp;#xf8;rer&quot; rolletype=&quot;REGN&quot;&gt;
                            &lt;enhet beskrivelse=&quot;Normal&quot; statuskode=&quot;OK&quot;&gt;
                                &lt;orgnr&gt;000000000&lt;/orgnr&gt;
                                &lt;navn1&gt;Dummy AS&lt;/navn1&gt;
                                &lt;adresse1&gt;Osloveien&lt;/adresse1&gt;
                                &lt;postnr&gt;2381&lt;/postnr&gt;
                                &lt;poststed&gt;OSLO&lt;/poststed&gt;
                                &lt;land landkode4=&quot;NOR&quot;&gt;Norge&lt;/land&gt;
                                &lt;fratraadt&gt;N&lt;/fratraadt&gt;
                                &lt;reTekst&gt;Autorisert regnskapsf&amp;#xf8;rerselskap&lt;/reTekst&gt;
                            &lt;/enhet&gt;
                        &lt;/rolle&gt;
                    &lt;/samendring&gt;
                &lt;/regnskapsfoerer&gt;
            &lt;/melding&gt;
        &lt;/grunndata&gt;
        """.trimIndent(),
    )

fun wrapWithRolleutskriftXmlEnvelope(xmlBody: String): String =
    """
    <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">

    <soap:Body>

        <hentRolleutskriftResponse xmlns="http://no/brreg/saksys/grunndata/ws">
            <return>$xmlBody
            </return>
        </hentRolleutskriftResponse>

    </soap:Body>

    </soap:Envelope>
    """.trimIndent()

fun wrapWithRollerXmlEnvelope(xmlBody: String): String =
    """
    <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">

    <soap:Body>

        <hentRollerResponse xmlns="http://no/brreg/saksys/grunndata/ws">
            <return>$xmlBody
            </return>
        </hentRollerResponse>

    </soap:Body>

    </soap:Envelope>
    """.trimIndent()
