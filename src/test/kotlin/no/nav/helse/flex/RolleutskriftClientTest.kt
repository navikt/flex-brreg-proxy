package no.nav.helse.flex

import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.reset
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.bean.override.mockito.MockitoBean

class RolleutskriftClientTest : FellesTestOppsett() {
    @MockitoBean
    lateinit var brregSoapClient: BrregSoapClient

    @Autowired
    lateinit var rolleutskriftClient: RolleutskriftClient

    @Test
    fun `burde retyre på feil`() {
        `when`(brregSoapClient.hentRolleutskrift(anyString())).thenThrow(RuntimeException("Test error"))

        runCatching {
            rolleutskriftClient.hentRolleutskriftRaw("12345678901")
        }

        verify(brregSoapClient, times(3)).hentRolleutskrift(anyString())

        reset(brregSoapClient)
    }
}
