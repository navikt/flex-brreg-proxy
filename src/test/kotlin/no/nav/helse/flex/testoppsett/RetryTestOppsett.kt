package no.nav.helse.flex.testoppsett

import org.springframework.resilience.annotation.EnableResilientMethods
import org.springframework.test.context.TestPropertySource

@EnableResilientMethods
@TestPropertySource(properties = ["BRREG_RETRY_BACKOFF_MS=10"])
annotation class RetryTestOppsett
