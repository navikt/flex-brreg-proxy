package no.nav.helse.flex.testoppsett

import mockwebserver3.Dispatcher
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import mockwebserver3.RecordedRequest
import no.nav.helse.flex.config.logger
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@Import(MockWebServereConfig::class)
annotation class MockServerTestOppsett

@TestConfiguration
class MockWebServereConfig {
    @Bean
    fun brregSoapServer() = brregSoapServer

    @Bean
    fun brregStubServer() = brregStubServer

    companion object {
        private val logger = logger()

        init {
            logger.info("[TEST] Starter mock webservere")
        }

        val brregSoapServer =
            MockWebServer()
                .also {
                    it.start()
                    System.setProperty("BRREG_URL", "http://localhost:${it.port}/brreg/grunndata/v1")
                }

        val brregStubServer =
            MockWebServer()
                .also {
                    it.start()
                    System.setProperty("BRREG_STUB_API_URL", "http://localhost:${it.port}")
                }
    }
}

fun simpleDispatcher(dispatcherFunc: (RecordedRequest) -> MockResponse): Dispatcher =
    object : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse = dispatcherFunc(request)
    }
