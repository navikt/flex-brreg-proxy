package no.nav.helse.flex

import no.nav.helse.flex.config.logger
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@Import(MockWebServereConfig::class)
annotation class MockServerTest

@TestConfiguration
class MockWebServereConfig {
    @Bean
    fun brregSoapServer() = brregSoapServer

    companion object {
        private val logger = logger()

        init {
            logger.info("[TEST] Starter mock webservere")
        }

        val brregSoapServer =
            MockWebServer()
                .also {
                    System.setProperty("BRREG_URL", "http://localhost:${it.port}/brreg/grunndata/v1")
                }
    }
}

fun simpleDispatcher(dispatcherFunc: (RecordedRequest) -> MockResponse): Dispatcher =
    object : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse = dispatcherFunc(request)
    }
