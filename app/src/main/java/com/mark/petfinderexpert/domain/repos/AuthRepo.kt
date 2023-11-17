package com.mark.petfinderexpert.domain.repos

import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    suspend fun refreshToken(): Flow<Resource<TokenResponse>>

}