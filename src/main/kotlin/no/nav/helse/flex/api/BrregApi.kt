package no.nav.helse.flex.api

import no.nav.helse.flex.clients.RolleutskriftClient
import no.nav.helse.flex.clients.SoapDeserializationException
import no.nav.helse.flex.clients.SoapServiceException
import no.nav.helse.flex.config.serialisertTilString
import no.nav.security.token.support.core.api.ProtectedWithClaims
import no.nav.security.token.support.core.api.Unprotected
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BrregApi(
    private val rolleutskriftClient: RolleutskriftClient,
) {
    @GetMapping("/api/v1/sjekk-brreg-tilgang")
    @Unprotected
    fun sjekkBrregTilgang(): ResponseEntity<Boolean> = ResponseEntity.ok(false)

    @PostMapping("/api/v1/rolleutskrift")
    @ProtectedWithClaims(issuer = "azureator")
    fun hentRolleutskrift(
        @RequestBody request: HentRolleutskriftRequest,
    ): ResponseEntity<String> {
        val fnr = request.fnr

        val result =
            try {
                rolleutskriftClient.hentRolleutskriftRaw(fnr)
            } catch (ex: SoapServiceException) {
                return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("Det oppstod et problem ved kall til Brreg. Årsak: ${ex.message}")
            } catch (ex: SoapDeserializationException) {
                return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Det oppstod et problem ved deserialisering av respons fra Brreg. Årsak: ${ex.message}")
            }
        val jsonResult =
            try {
                result.serialisertTilString()
            } catch (ex: Exception) {
                return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Jackson klarte ikke deserialisere brreg respons. Dette er kun i forbindelse med testing. Årsak: ${ex.message}")
            }
        return ResponseEntity.ok(jsonResult)
    }

    @PostMapping("/api/v1/roller")
    @ProtectedWithClaims(issuer = "azureator")
    fun hentRoller(
        @RequestBody request: HentRollerRequest,
    ): ResponseEntity<List<Rolle>> {
        val fnr = request.fnr
        val rolleTyper = request.rolleTyper

        val result =
            try {
                rolleutskriftClient.hentRoller(fnr, rolleTyper)
            } catch (ex: SoapServiceException) {
                return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body(emptyList())
            } catch (ex: SoapDeserializationException) {
                return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(emptyList())
            }
        return ResponseEntity.ok(result)
    }
}

data class HentRolleutskriftRequest(
    val fnr: String,
)

data class HentRollerRequest(
    val fnr: String,
    val rolleTyper: List<Rolletype>? = null,
)
