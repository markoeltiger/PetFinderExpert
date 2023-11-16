package com.mark.petfinderexpert.data.remote

import com.mark.petfinderexpert.BuildConfig
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PetFinderApi {

    @FormUrlEncoded
    @POST("oauth2/token")
    suspend fun getToken(
        @Field("grant_type") type: String = "client_credentials",
        @Field("client_id") key: String = BuildConfig.API_KEY,
        @Field("client_secret") secret: String = BuildConfig.API_SECERET
    ): TokenResponse

    companion object {
        const val BASE_URL = "https://api.petfinder.com/v2/oauth2/"

    }
}