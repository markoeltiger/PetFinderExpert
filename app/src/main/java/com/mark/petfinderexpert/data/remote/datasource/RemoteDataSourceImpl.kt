package com.mark.petfinderexpert.data.remote.datasource


import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.Flow
import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.PetFinderApi
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.data.remote.models.pets.PetsResponse
import com.mark.petfinderexpert.utils.network.SessionManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: PetFinderApi,
    @ApplicationContext private val context: Context
) : RemoteDataSource {
    private var sessionManager =SessionManager(context)

    override suspend fun refreshToken(): Flow<Resource<TokenResponse>> {

        return flow<Resource<TokenResponse>> {
            try {
                var tokenResponse = api.getToken()
                 sessionManager.saveAuthToken("${tokenResponse.token_type} ${tokenResponse.access_token}")
                emit(Resource.Success(tokenResponse))
            } catch (e: IOException) {

                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {

                e.printStackTrace()
                emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                null
            }


        }
    }

    override suspend fun petTypes(): Flow<Resource<PetTypesResponse>> {
        return flow<Resource<PetTypesResponse>> {
            try {
                var typesResponse = api.getPetTypes(sessionManager.fetchAuthToken()!!)
                emit(Resource.Success(typesResponse))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                null
            }
        }
    }

    // Make Pets Response
    override suspend fun getPets(): Flow<Resource<PetsResponse>> {
        return flow<Resource<PetsResponse>> {
            try {
                var typesResponse = api.getPets(sessionManager.fetchAuthToken()!!)
                emit(Resource.Success(typesResponse))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                null
            }
        }    }

}
