package com.mark.petfinderexpert.data.remote.models.pet_types


import com.google.gson.annotations.SerializedName

data class PetTypesResponse(
    @SerializedName("types")
    val types: List<Type>
)