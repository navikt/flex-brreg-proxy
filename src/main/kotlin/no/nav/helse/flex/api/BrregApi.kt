package no.nav.helse.flex.api

import no.nav.helse.flex.clients.*
import no.nav.security.token.support.core.api.Unprotected
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BrregApi(
    private val brregClient: BrregClient,
) {
    @GetMapping("/api/v1/brreg-status")
    @Unprotected
    fun sjekkBrregStatus(): ResponseEntity<BrregStatus> = ResponseEntity.ok(brregClient.hentStatus())

    @GetMapping("/api/v1/brreg-status-ok")
    @Unprotected
    fun sjekkBrregStatusOk(): ResponseEntity<Boolean> {
        val erStatusOk =
            try {
                brregClient.hentStatus().erOk
            } catch (_: BrregServerException) {
                false
            } catch (_: BrregClientException) {
                false
            }
        return ResponseEntity.ok(erStatusOk)
    }

    @PostMapping("/api/v1/roller")
    // @ProtectedWithClaims(issuer = "azureator")
    @Unprotected
    fun hentRoller(
        @RequestBody request: HentRollerRequest,
    ): ResponseEntity<RollerDto> {
        val fnr = request.fnr
        val rolleTyper = request.rolleTyper

        val roller = brregClient.hentRoller(fnr)
        val filtrerteRoller =
            if (rolleTyper != null) {
                roller.filter { it.rolletype in rolleTyper }
            } else {
                roller
            }

        return ResponseEntity.ok(RollerDto(filtrerteRoller))
    }
}

data class HentRollerRequest(
    val fnr: String,
    val rolleTyper: List<Rolletype>? = null,
)
