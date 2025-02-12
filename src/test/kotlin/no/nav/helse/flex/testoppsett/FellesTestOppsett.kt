package no.nav.helse.flex.testoppsett

import no.nav.helse.flex.Application
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(
    classes = [Application::class],
    properties = [
        "spring.main.allow-bean-definition-overriding=true",
    ],
)
@Target(AnnotationTarget.CLASS)
annotation class FellesTestOppsett
