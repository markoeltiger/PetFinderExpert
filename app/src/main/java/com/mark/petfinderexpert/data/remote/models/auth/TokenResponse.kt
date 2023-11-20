package com.mark.petfinderexpert.data.remote.models.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @SerialName("token_type")
    val token_type: String,
    @SerialName("expires_in")
    val expires_in: Int,
    @SerialName("access_token")
    val access_token: String
)