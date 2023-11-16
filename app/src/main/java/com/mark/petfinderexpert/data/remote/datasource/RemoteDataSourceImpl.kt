package com.mark.petfinderexpert.data.remote.datasource


import android.annotation.SuppressLint
import android.util.Log
import kotlinx.coroutines.flow.Flow
import com.mark.moviemaster.utils.network.Resource
import com.mark.petfinderexpert.data.remote.PetFinderApi
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: PetFinderApi,

    ): RemoteDataSource {


    override suspend fun refreshToken(): Flow<Resource<TokenResponse>> {
        return flow<Resource<TokenResponse>> {
            try {
                var tokenResponse= api.getToken()
                emit(Resource.Success(tokenResponse))
            } catch(e: IOException) {
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
}
