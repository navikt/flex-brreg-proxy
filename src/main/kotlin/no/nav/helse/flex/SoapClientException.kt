package no.nav.helse.flex

open class SoapClientException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)

open class SoapServiceException(
    message: String,
    cause: Throwable? = null,
) : SoapClientException(message, cause)

open class SoapDeserializationException(
    message: String,
    cause: Throwable? = null,
) : SoapClientException(message, cause)
