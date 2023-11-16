package com.mark.petfinderexpert.data.remote.datasource

import com.mark.moviemaster.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun refreshToken(): Flow<Resource<TokenResponse>>

}