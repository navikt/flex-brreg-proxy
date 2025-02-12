package no.nav.helse.flex.clients

import no.nav.helse.flex.testoppsett.FellesTestOppsett
import no.nav.helse.flex.testoppsett.RetryTestOppsett
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.reset
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.retry.annotation.EnableRetry
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.bean.override.mockito.MockitoBean

@FellesTestOppsett
@RetryTestOppsett
class BrregServiceIsolertTest {
    @MockitoBean
    lateinit var brregSoapClient: BrregSoapClient

    @Autowired
    lateinit var brregService: BrregService

    @Test
    fun `burde retrye på feil ved hentRoller`() {
        `when`(brregSoapClient.hentRolleutskrift(anyString())).thenThrow(SoapServiceException("Test error"))

        runCatching {
            brregService.hentRoller("12345678901")
        }

        verify(brregSoapClient, times(3)).hentRolleutskrift(anyString())

        reset(brregSoapClient)
    }
}
