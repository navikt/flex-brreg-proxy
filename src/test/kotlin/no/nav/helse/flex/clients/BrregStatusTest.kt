package no.nav.helse.flex.clients

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class BrregStatusTest {
    @Test
    fun `anonymiserFnr burde anonymisere`() {
        BrregStatus("aa 12345678910 bb", true, HttpStatus.OK).anonymisertMelding() shouldBe "aa XXXXXXXXXXX bb"
    }
}
