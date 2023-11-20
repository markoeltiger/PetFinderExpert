package com.mark.petfinderexpert.data.remote

import com.mark.petfinderexpert.BuildConfig
import com.mark.petfinderexpert.data.remote.models.auth.TokenResponse
import com.mark.petfinderexpert.data.remote.models.pet_types.PetTypesResponse
import com.mark.petfinderexpert.data.remote.models.pets.PetsResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
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

    @GET("types")
    suspend fun getPetTypes(@Header("Authorization") authHeader:String): PetTypesResponse
    @GET("animals")
    suspend fun getPets(@Header("Authorization") authHeader:String): PetsResponse


    companion object {
        const val BASE_URL = "https://api.petfinder.com/v2/"

    }
}