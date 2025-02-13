package no.nav.helse.flex.clients

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class BrregStatusTest {
    @Test
    fun `anonymiserFnr burde anonymisere`() {
        BrregStatus("aa 12345678910 bb", true).anonymisertMelding() `should be equal to` "aa XXXXXXXXXXX bb"
    }
}
