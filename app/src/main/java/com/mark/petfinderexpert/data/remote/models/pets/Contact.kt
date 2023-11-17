package com.mark.petfinderexpert.data.remote.models.pets


import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("address")
    val address: Address,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String
)