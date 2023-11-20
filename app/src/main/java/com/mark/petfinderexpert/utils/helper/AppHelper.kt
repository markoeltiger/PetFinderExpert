package com.mark.petfinderexpert.utils.helper

import androidx.compose.ui.graphics.Color
import com.mark.petfinderexpert.data.remote.models.pets.Animal
import kotlin.random.Random

object AppHelper  {
    var selectedPet: Animal? = null

    fun HandleNull(string: String?):String  {
       if (string.isNullOrEmpty()) return "NA"
        else if (string.equals("null")) return "NA"
        else return string
     }
    fun Color.Companion.random() : Color {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        return Color(red, green, blue)
    }
}