package com.mark.petfinderexpert.data.remote.repos


import android.util.Log
import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.datasource.RemoteDataSource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.domain.repos.AuthRepo
import com.mark.petfinderexpert.utils.network.SessionManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
private val remoteDataSource: RemoteDataSource
) : AuthRepo {
    override suspend fun refreshToken(): Flow<Resource<TokenResponse>> {
        return flow<Resource<TokenResponse>> {
            var refreshTokenResponse = remoteDataSource.refreshToken()
            refreshTokenResponse.collect {
                when (it) {
                    is Resource.Success -> {
                        Log.e("tokenResponse",it.data.toString())

                        emit(Resource.Success(it.data))
                     }
                    else -> {
                        emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                    }
                }
            }
        }    }
}