package com.mark.petfinderexpert.presentation.viewmodel.pets.ui_state

import com.mark.petfinderexpert.data.remote.models.pet_types.Type
import com.mark.petfinderexpert.data.remote.models.pets.Animal

data class PetsListUIState(
    val types: List<Type> = emptyList(),
    val pets: List<Animal> = emptyList(),
    val msg:String = "",
    val isError:Boolean =false,
                        )
