package com.mark.petfinderexpert.data.remote.repos


import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.datasource.RemoteDataSource
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.data.remote.models.pets.PetsResponse
import com.mark.petfinderexpert.domain.repos.PetsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
private val remoteDataSource: RemoteDataSource
) : PetsRepo {

    override suspend fun getPetTypes(): Flow<Resource<PetTypesResponse>> {
        return flow<Resource<PetTypesResponse>> {
            remoteDataSource.petTypes().collect {
                when (it) {
                    is Resource.Success -> {
                        emit(Resource.Success(it.data))
                    }
                    else -> {
                        emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                    }
                }
            }
        }
    }
    //Get All Pets or specific genre pets
    override suspend fun getPets(type: String?): Flow<Resource<PetsResponse>> {
        return flow<Resource<PetsResponse>> {
            var mType = if (type.isNullOrEmpty()||type.equals("All")){""} else type
                remoteDataSource.getPets(mType).collect {
                    when (it) {
                        is Resource.Success -> {
                            emit(Resource.Success(it.data))
                        }
                        else -> {
                            emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                        }
                    }
                }

        }
    }
}