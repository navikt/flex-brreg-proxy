package no.nav.helse.flex.testoppsett

import no.nav.security.token.support.spring.api.EnableJwtTokenValidation
import no.nav.security.token.support.spring.test.EnableMockOAuth2Server
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.boot.webmvc.test.autoconfigure.MockMvcPrint

@EnableMockOAuth2Server
@EnableJwtTokenValidation
@AutoConfigureMockMvc(print = MockMvcPrint.NONE, printOnlyOnFailure = false)
annotation class ApiTestOppsett
