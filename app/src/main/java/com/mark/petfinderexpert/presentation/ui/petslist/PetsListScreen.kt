package com.mark.petfinderexpert.presentation.ui.petslist


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.petfinderexpert.presentation.ui.components.SinglePetItem
import com.mark.petfinderexpert.presentation.ui.components.SingleTypeItem
import com.mark.petfinderexpert.presentation.viewmodel.pets.PetsListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsListScreen(
    navController: NavController,
    viewModel: PetsListViewModel = hiltViewModel()
) {
    val petsListUIState by viewModel.petTypes.collectAsState()
    Column {
        //List of Categories
        LazyRow {
            items(petsListUIState!!.types.size) { type ->
                SingleTypeItem(
                    type = petsListUIState!!.types.get(type),
                    onItemClick = {

                    }
                )
            }
        }
        LazyColumn {
            items(petsListUIState.pets.size) { pet ->
                SinglePetItem(
                    animal = petsListUIState.pets.get(pet),
                    onItemClick = {

                    }
                )
            }
        }

    }
}


