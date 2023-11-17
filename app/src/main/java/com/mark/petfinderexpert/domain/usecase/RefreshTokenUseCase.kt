package com.mark.petfinderexpert.domain.usecase

import android.util.Log
import com.mark.petfinderexpert.utils.network.Resource
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.domain.repos.AuthRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val authRepo: AuthRepo
) {
    suspend fun refreshToken(): Flow<Resource<TokenResponse>> {

         return  authRepo.refreshToken()
    }
}