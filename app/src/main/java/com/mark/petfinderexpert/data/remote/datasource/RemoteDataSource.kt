package com.mark.petfinderexpert.data.remote.datasource

import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.data.remote.models.pets.PetsResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun refreshToken(): Flow<Resource<TokenResponse>>
    suspend fun petTypes(): Flow<Resource<PetTypesResponse>>
    suspend fun getPets(type:String): Flow<Resource<PetsResponse>>

}