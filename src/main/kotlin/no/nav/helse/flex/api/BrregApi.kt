package no.nav.helse.flex.api

import no.nav.helse.flex.clients.RolleutskriftClient
import no.nav.helse.flex.clients.SoapDeserializationException
import no.nav.helse.flex.clients.SoapServiceException
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

    @PostMapping("/api/v1/roller")
    @ProtectedWithClaims(issuer = "azureator")
    fun hentRoller(
        @RequestBody request: HentRollerRequest,
    ): ResponseEntity<RollerDto> {
        val fnr = request.fnr
        val rolleTyper = request.rolleTyper

        val result =
            try {
                rolleutskriftClient.hentRoller(fnr, rolleTyper)
            } catch (ex: SoapServiceException) {
                return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .build()
            } catch (ex: SoapDeserializationException) {
                return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build()
            }
        return ResponseEntity.ok(RollerDto(result))
    }
}

data class RollerDto(
    val roller: List<Rolle>,
)

data class HentRollerRequest(
    val fnr: String,
    val rolleTyper: List<Rolletype>? = null,
)
