package com.mark.petfinderexpert.data.remote.models.pets


import com.google.gson.annotations.SerializedName

data class Colors(
    @SerializedName("primary")
    val primary: String,
    @SerializedName("secondary")
    val secondary: String,
    @SerializedName("tertiary")
    val tertiary: Any
)