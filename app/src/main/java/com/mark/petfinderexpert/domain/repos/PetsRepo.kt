package com.mark.petfinderexpert.domain.repos

import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import kotlinx.coroutines.flow.Flow

interface PetsRepo {
    suspend fun getPetTypes(): Flow<Resource<PetTypesResponse>>

}