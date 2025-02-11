package no.nav.helse.flex.api

import no.nav.helse.flex.clients.BrregService
import no.nav.helse.flex.clients.BrregStatus
import no.nav.helse.flex.clients.Rolle
import no.nav.helse.flex.clients.Rolletype
import no.nav.helse.flex.clients.SoapServiceException
import no.nav.security.token.support.core.api.ProtectedWithClaims
import no.nav.security.token.support.core.api.Unprotected
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BrregApi(
    private val brregService: BrregService,
) {
    @GetMapping("/api/v1/brreg-status")
    @Unprotected
    fun sjekkBrregStatus(): ResponseEntity<BrregStatus> = ResponseEntity.ok(brregService.hentResponsStatus())

    @GetMapping("/api/v1/brreg-status-ok")
    @Unprotected
    fun sjekkBrregStatusOk(): ResponseEntity<Boolean> {
        val erStatusOk =
            try {
                brregService.hentResponsStatus().erOk()
            } catch (_: SoapServiceException) {
                false
            }
        return ResponseEntity.ok(erStatusOk)
    }

    @Unprotected
    @PostMapping("/api/v1/roller-ja")
    fun hentRollerJa(
        @RequestBody request: HentRollerRequest,
    ): ResponseEntity<RollerDto> = hentRoller(request)

    @PostMapping("/api/v1/roller")
    @ProtectedWithClaims(issuer = "azureator")
    fun hentRoller(
        @RequestBody request: HentRollerRequest,
    ): ResponseEntity<RollerDto> {
        val fnr = request.fnr
        val rolleTyper = request.rolleTyper

        val result = brregService.hentRoller(fnr, rolleTyper)

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
