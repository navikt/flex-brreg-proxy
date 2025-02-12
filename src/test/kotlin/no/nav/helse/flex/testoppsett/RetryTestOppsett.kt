package no.nav.helse.flex.testoppsett

import org.springframework.retry.annotation.EnableRetry
import org.springframework.test.context.TestPropertySource

@EnableRetry
@TestPropertySource(properties = ["BRREG_RETRY_BACKOFF_MS=100"])
annotation class RetryTestOppsett
