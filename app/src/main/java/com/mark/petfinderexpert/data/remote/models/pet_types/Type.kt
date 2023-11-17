package com.mark.petfinderexpert.data.remote.models.pet_types


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("coats")
    val coats: List<String>,
    @SerializedName("colors")
    val colors: List<String>,
    @SerializedName("genders")
    val genders: List<String>,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("name")
    val name: String
)