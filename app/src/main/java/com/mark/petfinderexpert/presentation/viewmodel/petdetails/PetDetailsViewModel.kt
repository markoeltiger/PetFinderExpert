package com.mark.petfinderexpert.presentation.viewmodel.petdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mark.petfinderexpert.domain.usecase.GetPetTypesUseCase
import com.mark.petfinderexpert.domain.usecase.GetPetsUseCase
import com.mark.petfinderexpert.domain.usecase.RefreshTokenUseCase
import com.mark.petfinderexpert.presentation.viewmodel.petdetails.ui_state.PetDetailsUIState
import com.mark.petfinderexpert.presentation.viewmodel.pets.ui_state.PetsListUIState
import com.mark.petfinderexpert.utils.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
    private val refreshTokenUseCase: RefreshTokenUseCase,
    private val getPetTypesUseCase: GetPetTypesUseCase,
    private val getPetsUseCase: GetPetsUseCase

    ) : ViewModel() {
       private val viewModelScope = CoroutineScope(Dispatchers.IO)
    val petDetails = MutableStateFlow(PetDetailsUIState())






    }


