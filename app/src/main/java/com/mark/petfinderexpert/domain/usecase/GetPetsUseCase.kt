package com.mark.petfinderexpert.domain.usecase

import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.pets.PetsResponse
import com.mark.petfinderexpert.domain.repos.PetsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetPetsUseCase @Inject constructor(
    private val petsRepo: PetsRepo
) : Flow<Any> {
    suspend fun getPets(type: String?): Flow<Resource<PetsResponse>> {
         return  petsRepo.getPets(type)
    }

    override suspend fun collect(collector: FlowCollector<Any>) {
     }
}