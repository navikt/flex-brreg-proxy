package no.nav.helse.flex.testdata

fun lagBrregStubIsAliveResponse(isAlive: Boolean) = if (isAlive) "OK" else "NOT OK"

fun lagBrregStubResponse(fnr: String = "11111111111") =
    """
    {
        "fnr": $fnr,
        "fodselsdato": "1990-01-01",
        "navn": {
            "navn1": "Ola",
            "navn2": "Normann"
        },
        "adresse": {
            "adresse1": "Gate 1",
            "adresse2": "",
            "adresse3": "",
            "postnr": "1234",
            "poststed": "Oslo",
            "landKode": "NO",
            "kommunenr": "0301"
        },
        "enheter": [
            {
                "registreringsdato": "2000-01-01",
                "rolle": "INNH",
                "rollebeskrivelse": "Innehaver",
                "orgNr": 123456789,
                "foretaksNavn": {
                    "navn1": "SELSKAP AS",
                    "navn2": ""
                },
                "forretningsAdresse": {
                    "adresse1": "Gate 2",
                    "adresse2": "",
                    "adresse3": "",
                    "postnr": "5678",
                    "poststed": "Bergen",
                    "landKode": "NO",
                    "kommunenr": "1201"
                },
                "postAdresse": {
                    "adresse1": "Postboks 1",
                    "adresse2": "",
                    "adresse3": "",
                    "postnr": "9100",
                    "poststed": "Tromsø",
                    "landKode": "NO",
                    "kommunenr": "1902"
                },
                "personRolle": [
                    {
                        "egenskap": "Eier",
                        "fratraadt": false
                    }
                ]
            }
        ],
        "hovedstatus": 0,
        "understatuser": []
    }
    """.trimIndent()
