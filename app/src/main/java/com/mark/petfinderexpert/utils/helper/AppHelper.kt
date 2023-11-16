package com.mark.moviemaster.utils.helper

import androidx.compose.ui.graphics.Color
 import kotlin.random.Random

object AppHelper  {

    fun Color.Companion.random() : Color {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        return Color(red, green, blue)
    }
}