package no.nav.helse.flex.clients

open class SoapClientException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)

open class SoapServiceException(
    message: String,
    cause: Throwable? = null,
    val brregStatus: BrregStatus? = null,
) : SoapClientException(message, cause)

open class SoapDeserializationException(
    message: String,
    cause: Throwable? = null,
) : SoapClientException(message, cause)
