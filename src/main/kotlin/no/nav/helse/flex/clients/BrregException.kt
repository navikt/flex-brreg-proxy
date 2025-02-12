package no.nav.helse.flex.clients

open class BrregException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)

open class BrregServerException(
    message: String,
    cause: Throwable? = null,
    val brregStatus: BrregStatus? = null,
) : BrregException(message, cause)

open class BrregDeserializationException(
    message: String,
    cause: Throwable? = null,
) : BrregException(message, cause)
