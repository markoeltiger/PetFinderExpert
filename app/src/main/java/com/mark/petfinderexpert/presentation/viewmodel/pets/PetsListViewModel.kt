package com.mark.petfinderexpert.presentation.viewmodel.pets

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mark.petfinderexpert.domain.usecase.GetPetTypesUseCase
import com.mark.petfinderexpert.domain.usecase.GetPetsUseCase
import com.mark.petfinderexpert.domain.usecase.RefreshTokenUseCase
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
class PetsListViewModel @Inject constructor(
    private val refreshTokenUseCase: RefreshTokenUseCase,
    private val getPetTypesUseCase: GetPetTypesUseCase,
    private val getPetsUseCase: GetPetsUseCase

    ) : ViewModel() {
       private val viewModelScope = CoroutineScope(Dispatchers.IO)
    val petTypes =
        MutableStateFlow(PetsListUIState())

    init {
        getToken()
        getPetTypes()
        getPets()
      }

      fun getToken() {
        viewModelScope.launch() {
        refreshTokenUseCase.refreshToken().collect{
            Log.e("toke",it.toString())
        }
        }
    }

    fun getPetTypes() {
        viewModelScope.launch() {
            getPetTypesUseCase.getTypes().collect { types ->
                petTypes.update {
                    when (types) {
                        is Resource.Success -> {
                            it.copy(
                                types = types.data!!.types
                            )
                        }
                        else -> {
                            it.copy(
                                types = emptyList(),
                                msg = types.message!!,
                                isError = true
                            )
                        }
                    }

                }
            }
        }

    }
    fun getPets() {
        viewModelScope.launch() {
            getPetsUseCase.getPets().collect { pets ->
                petTypes.update {
                    when (pets) {
                        is Resource.Success -> {
                            it.copy(
                                pets =pets.data!!.animals
                            )
                        }
                        else -> {
                            it.copy(
                                types = emptyList(),
                                msg = pets.message!!,
                                isError = true
                            )
                        }
                    }

                }
            }
        }

    }
    }


