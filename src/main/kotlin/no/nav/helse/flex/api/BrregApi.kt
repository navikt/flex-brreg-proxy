package no.nav.helse.flex.api

import no.nav.helse.flex.clients.RolleutskriftClient
import no.nav.helse.flex.clients.SoapDeserializationException
import no.nav.helse.flex.clients.SoapServiceException
import no.nav.helse.flex.config.logger
import no.nav.helse.flex.config.serialisertTilString
import no.nav.security.token.support.core.api.ProtectedWithClaims
import no.nav.security.token.support.core.api.Unprotected
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BrregApi(
    private val rolleutskriftClient: RolleutskriftClient,
) {
    private val logger = logger()

    @GetMapping("/api/v1/sjekk-brreg-tilgang")
    @Unprotected
    fun sjekkBrregTilgang(): ResponseEntity<Boolean> = ResponseEntity.ok(false)

    @GetMapping("/api/v1/rolleutskrift/{fnr}")
    @ProtectedWithClaims(issuer = "azureator")
    fun hentRolleutskrift(
        @PathVariable("fnr") fnr: String,
    ): ResponseEntity<String> {
        val result =
            try {
                rolleutskriftClient.hentRolleutskriftRaw(fnr)
            } catch (ex: SoapServiceException) {
                return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body("Det oppstod et problem ved kall til Brreg. Cause: ${ex.message}")
            } catch (ex: SoapDeserializationException) {
                return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Det oppstod et problem ved deserialisering av respons fra Brreg. Cause: ${ex.message}")
            }
        val jsonResult =
            try {
                result.serialisertTilString()
            } catch (ex: Exception) {
                return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Jackson klarte ikke deserialisere brreg respons. Dette er kun i forbindelse med testing. Cause: ${ex.message}")
            }
        return ResponseEntity.ok(jsonResult)
    }
}
