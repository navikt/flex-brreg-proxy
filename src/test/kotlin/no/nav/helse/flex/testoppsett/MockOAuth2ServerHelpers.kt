package no.nav.helse.flex.testoppsett

import no.nav.security.mock.oauth2.MockOAuth2Server
import no.nav.security.mock.oauth2.token.DefaultOAuth2TokenCallback
import java.util.HashMap
import java.util.UUID

fun MockOAuth2Server.skapAzureJwt(subject: String = "test-client-id") = buildAzureClaimSet(subject = subject)

fun MockOAuth2Server.buildAzureClaimSet(
    subject: String,
    issuer: String = "azureator",
    audience: String = "flex-brreg-proxy-client-id",
    claims: HashMap<String, String> = hashMapOf(),
): String =
    this.token(
        subject = "Vi sjekker azp",
        issuerId = issuer,
        clientId = subject,
        audience = audience,
        claims = claims,
    )

fun MockOAuth2Server.token(
    subject: String,
    issuerId: String = "selvbetjening",
    clientId: String = UUID.randomUUID().toString(),
    audience: String = "loginservice-client-id",
    claims: Map<String, Any> = mapOf("acr" to "Level4"),
): String =
    this
        .issueToken(
            issuerId,
            clientId,
            DefaultOAuth2TokenCallback(
                issuerId = issuerId,
                subject = subject,
                audience = listOf(audience),
                claims = claims,
                expiry = 3600,
            ),
        ).serialize()
