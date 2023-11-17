package com.mark.petfinderexpert.data.remote.models.pets


import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("age")
    val age: String,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("breeds")
    val breeds: Breeds,
    @SerializedName("coat")
    val coat: String,
    @SerializedName("colors")
    val colors: Colors,
    @SerializedName("contact")
    val contact: Contact,
    @SerializedName("description")
    val description: String,
    @SerializedName("distance")
    val distance: Any,
    @SerializedName("environment")
    val environment: Environment,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("organization_animal_id")
    val organizationAnimalId: String,
    @SerializedName("organization_id")
    val organizationId: String,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("primary_photo_cropped")
    val primaryPhotoCropped: PrimaryPhotoCropped,
    @SerializedName("published_at")
    val publishedAt: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("status_changed_at")
    val statusChangedAt: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("videos")
    val videos: List<Any>
)