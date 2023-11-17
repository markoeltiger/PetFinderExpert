package com.mark.petfinderexpert.domain.usecase

import android.util.Log
import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.domain.repos.AuthRepo
import com.mark.petfinderexpert.domain.repos.PetsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPetTypesUseCase @Inject constructor(
    private val petsRepo: PetsRepo
) {
    suspend fun getTypes(): Flow<Resource<PetTypesResponse>> {
         return  petsRepo.getPetTypes()
    }
}