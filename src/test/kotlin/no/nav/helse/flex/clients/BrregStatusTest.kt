package no.nav.helse.flex.clients

import no.nav.helse.flex.clients.BrregStatus.Companion.anonymiserFnr
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class BrregStatusTest {
    @Test
    fun `anonymiserFnr burde anonymisere`() {
        "aa 12345678910 bb".anonymiserFnr() `should be equal to` "aa XXXXXXXXXXX bb"
    }
}
