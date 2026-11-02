package no.nav.helse.flex.clients

import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import no.nav.helse.flex.testoppsett.BrregMockClientOppsett
import no.nav.helse.flex.testoppsett.FellesTestOppsett
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
        roller shouldBe
            listOf(
                RolleDto(
                    Rolletype.INNH,
                    organisasjonsnummer = "123456789",
                    organisasjonsnavn = "Mitt Helt Eget Selskap",
                ),
            )
    }

    @Test
    fun `burde returnere status`() {
        val status = brregMockClient.hentStatus()
        status.erOk.shouldBeTrue()
    }
}
