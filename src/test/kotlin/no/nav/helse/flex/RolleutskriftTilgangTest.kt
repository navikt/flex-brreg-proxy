package no.nav.helse.flex

import org.amshove.kluent.`should be false`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RolleutskriftTilgangTest : FellesTestOppsett() {

    @Autowired
    lateinit var rolleutskriftClient: RolleutskriftClient

    @Test
    fun `burde ikke ha tilgang`() {
        rolleutskriftClient.harTilgang().`should be false`()
    }

}
