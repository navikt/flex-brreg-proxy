package no.nav.helse.flex

import no.nav.helse.flex.config.logger
import okhttp3.mockwebserver.MockWebServer
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class MockWebServereConfig {
    @Bean
    fun brregSoapServer() = brregSoapServer

    companion object {
        val logger = logger()

        init {
            logger.info("[TEST] Starter mock webservere")
        }

        val brregSoapServer =
            MockWebServer().also {
                System.setProperty("BRREG_URL", "https://localhost:${it.port}/brreg/grunndata/v1")
            }
    }
}
