package no.nav.helse.flex

import no.nav.helse.flex.config.logger
import okhttp3.mockwebserver.MockWebServer
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import kotlin.apply

@TestConfiguration
class MockWebServereConfig {
    @Bean
    fun pdlMockWebServer() = pdlMockWebServer

    companion object {
        val logger = logger()

        init {
            logger.info("[TEST] Starter mock webservere")
        }

        val pdlMockWebServer =
            MockWebServer().apply {
                System.setProperty("PDL_BASE_URL", "http://localhost:$port")
            }
    }
}
