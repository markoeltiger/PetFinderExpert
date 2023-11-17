package com.mark.petfinderexpert.data.remote.models.pets


import com.google.gson.annotations.SerializedName

data class Next(
    @SerializedName("href")
    val href: String
)