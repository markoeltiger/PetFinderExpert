package com.mark.petfinderexpert.presentation.viewmodel.pets.ui_state

import com.mark.petfinderexpert.data.remote.models.pet_types.Type

data class PetsListUIState(
    val types: List<Type> = emptyList(),
    val pets: List<String> = emptyList(),
    val msg:String = "",
    val isError:Boolean =false,
                        )
