package com.mark.petfinderexpert.data.remote.datasource

import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun refreshToken(): Flow<Resource<TokenResponse>>
    suspend fun petTypes(): Flow<Resource<PetTypesResponse>>

}