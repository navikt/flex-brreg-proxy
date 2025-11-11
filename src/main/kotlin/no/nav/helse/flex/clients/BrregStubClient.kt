package no.nav.helse.flex.clients

import org.springframework.context.annotation.Profile
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.client.ClientHttpResponse
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.toEntity

@Profile("dev")
@Component
class BrregStubClient(
    private val brregRestClient: RestClient,
) : BrregClient {
    @Retryable(
        include = [BrregServerException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    override fun hentStatus(): BrregStatus {
        val uri = brregRestClient.get().uri { uriBuilder -> uriBuilder.path("/isAlive").build() }
        val res =
            uri
                .header("")
                .retrieve()
                .mapStatusTilExceptions()
                .toEntity<String>()
        return BrregStatus(
            melding = res.body ?: "",
            erOk = res.statusCode.is2xxSuccessful && res.body?.removeSurrounding("\"") == "OK",
            httpStatus = HttpStatus.valueOf(res.statusCode.value()),
        )
    }

    @Retryable(
        include = [BrregServerException::class],
        maxAttempts = 3,
        backoff = Backoff(delayExpression = "\${BRREG_RETRY_BACKOFF_MS:1000}"),
    )
    override fun hentRoller(fnr: String): List<RolleDto> =
        hentRolleoversikt(fnr)?.enheter?.map {
            RolleDto(
                rolletype = Rolletype.valueOf(it.rolle),
                organisasjonsnummer = it.orgNr.toString(),
                organisasjonsnavn = it.foretaksNavn?.fulltNavn() ?: "",
            )
        } ?: emptyList()

    fun hentRolleoversikt(fnr: String): BrregStubResponse? {
        val uri = brregRestClient.get().uri { uriBuilder -> uriBuilder.path("/api/v2/rolleoversikt").build() }
        return try {
            uri
                .header("Nav-Personident", fnr)
                .retrieve()
                .mapStatusTilExceptions()
                .toEntity<BrregStubResponse>()
                .body
        } catch (e: BrregClientException) {
            if (e.httpStatus == 404) {
                null
            } else {
                throw e
            }
        }
    }
}

internal fun RestClient.ResponseSpec.mapStatusTilExceptions(): RestClient.ResponseSpec =
    this
        .onStatus(HttpStatusCode::is4xxClientError) { _, response ->
            throw BrregClientException(
                message = "Feil fra Brreg API ved henting av roller",
                httpStatus = response.statusCode.value(),
                httpMessage = response.statusText,
            )
        }.onStatus(HttpStatusCode::is5xxServerError) { _, response ->
            throw BrregServerException(
                message = "Feil fra Brreg API ved henting av roller",
                brregStatus = lagStatusMelding(response),
            )
        }

internal fun lagStatusMelding(response: ClientHttpResponse): BrregStatus =
    BrregStatus(
        melding = response.statusText,
        erOk = response.statusCode.is2xxSuccessful,
        httpStatus = HttpStatus.valueOf(response.statusCode.value()),
    )

data class BrregStubResponse(
    val fnr: String,
    val fodselsdato: String? = null,
    val navn: Navn,
    val adresse: Adresse,
    val enheter: List<Enhet>,
    val hovedstatus: Int? = null,
    val understatuser: List<Int>? = null,
)

data class Navn(
    val navn1: String,
    val navn2: String? = null,
    val navn3: String? = null,
) {
    fun fulltNavn(): String = listOfNotNull(navn1, navn2, navn3).filter { it.isNotBlank() }.joinToString(" ")
}

data class Adresse(
    val adresse1: String,
    val adresse2: String? = null,
    val adresse3: String? = null,
    val postnr: String? = null,
    val poststed: String? = null,
    val landKode: String,
    val kommunenr: String? = null,
) {
    fun fullAdresse(): String = listOfNotNull(adresse1, adresse2, adresse3).filter { it.isNotBlank() }.joinToString(" ")
}

data class Enhet(
    val registreringsdato: String,
    val rolle: String,
    val rollebeskrivelse: String? = null,
    val orgNr: Int,
    val foretaksNavn: Navn? = null,
    val forretningsAdresse: Adresse? = null,
    val postAdresse: Adresse? = null,
    val personRolle: List<PersonRolle>? = null,
)

data class PersonRolle(
    val egenskap: String,
    val fratraadt: Boolean,
)
