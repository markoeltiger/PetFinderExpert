package com.mark.petfinderexpert.data.remote.models.pets


import com.google.gson.annotations.SerializedName

data class PetsResponse(
    @SerializedName("animals")
    val animals: List<Animal>,
    @SerializedName("pagination")
    val pagination: Pagination?
)