package com.mark.moviemaster.presentation.ui.movies.events

sealed class PetListingEvent {
     data class onPetGenreSelection(val type: String): PetListingEvent()
}

