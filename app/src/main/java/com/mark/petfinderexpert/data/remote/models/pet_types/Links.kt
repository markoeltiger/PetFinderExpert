package com.mark.petfinderexpert.data.remote.models.pet_types


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("breeds")
    val breeds: Breeds,
    @SerializedName("self")
    val self: Self
)