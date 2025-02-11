package no.nav.helse.flex.clients

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.toEntity

@Component
class BrregStubClient(
    @Value("\${BRREG_STUB_API_URL}")
    private val url: String,
    restClientBuilder: RestClient.Builder,
) {
    private val restClient = restClientBuilder.baseUrl(url).build()

    fun hentRolleoversikt(fnr: String): BrregStubResponse? {
        val uri = restClient.get().uri { uriBuilder -> uriBuilder.path("/api/v2/rolleoversikt").build() }
        return uri
            .header("Nav-Personident", fnr)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, { _, response ->
                throw BrregStubClientException(
                    message = "Feil ved kall til BrregStub: ${response.statusCode}",
                    cause = RuntimeException(response.statusText),
                )
            })
            .toEntity<BrregStubResponse>()
            .body
    }
}

open class BrregStubClientException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message)

data class BrregStubResponse(
    val fnr: String,
    val fodselsdato: String,
    val navn: Navn,
    val adresse: Adresse,
    val enheter: List<Enhet>,
    val hovedstatus: Int,
    val understatuser: List<Int>,
)

data class Navn(
    val navn1: String,
    val navn2: String,
    val navn3: String,
)

data class Adresse(
    val adresse1: String,
    val adresse2: String,
    val adresse3: String,
    val postnr: String,
    val poststed: String,
    val landKode: String,
    val kommunenr: String,
)

data class Enhet(
    val registreringsdato: String,
    val rolle: String,
    val rollebeskrivelse: String,
    val orgNr: Int,
    val foretaksNavn: Navn,
    val forretningsAdresse: Adresse,
    val postAdresse: Adresse,
    val personRolle: List<PersonRolle>,
)

data class PersonRolle(
    val egenskap: String,
    val fratraadt: Boolean,
)
