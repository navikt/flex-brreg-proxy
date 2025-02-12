package no.nav.helse.flex

import no.nav.security.token.support.spring.api.EnableJwtTokenValidation
import no.nav.security.token.support.spring.test.EnableMockOAuth2Server
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(
    classes = [Application::class],
    properties = [
        "spring.main.allow-bean-definition-overriding=true",
    ],
)
@Target(AnnotationTarget.CLASS)
annotation class FellesTestOppsett


@EnableMockOAuth2Server
@EnableJwtTokenValidation
@AutoConfigureMockMvc(print = MockMvcPrint.NONE, printOnlyOnFailure = false)
@TestPropertySource(properties = ["BRREG_TIMEOUT_MS=10"])
annotation class ApiTest
