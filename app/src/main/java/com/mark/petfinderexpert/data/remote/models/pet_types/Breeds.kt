package com.mark.petfinderexpert.data.remote.models.pet_types


import com.google.gson.annotations.SerializedName

data class Breeds(
    @SerializedName("href")
    val href: String
)