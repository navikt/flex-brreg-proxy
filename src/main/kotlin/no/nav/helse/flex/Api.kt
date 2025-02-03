package no.nav.helse.flex

import no.nav.helse.flex.config.logger
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class Api {
    private val logger = logger()

    @GetMapping("/api/v1/check-brreg-auth")
    @ResponseBody
    fun getSykmeldinger(): ResponseEntity<Boolean> {
        // val fnr = tokenxValidering.validerFraDittSykefravaer()
        return ResponseEntity.ok(false)
    }
}
