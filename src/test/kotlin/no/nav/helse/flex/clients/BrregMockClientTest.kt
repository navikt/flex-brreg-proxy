package no.nav.helse.flex.clients

import no.nav.helse.flex.testoppsett.BrregMockClientOppsett
import no.nav.helse.flex.testoppsett.FellesTestOppsett
import org.amshove.kluent.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@FellesTestOppsett
@BrregMockClientOppsett
class BrregMockClientTest {
    @Autowired
    lateinit var brregMockClient: BrregMockClient

    @Test
    fun `burde returnere rolle`() {
        val roller = brregMockClient.hentRoller("fnr")
        roller `should be equal to`
            listOf(
                Rolle(
                    Rolletype.INNH,
                    orgnummer = "123456789",
                    orgnavn = "Mitt Helt Eget Selskap",
                ),
            )
    }

    @Test
    fun `burde returnere status`() {
        val status = brregMockClient.hentStatus()
        status.erOk.shouldBeTrue()
    }
}
