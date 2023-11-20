package com.mark.petfinderexpert.presentation.ui.petslist


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.moviemaster.presentation.ui.movies.events.PetListingEvent
import com.mark.petfinderexpert.R
import com.mark.petfinderexpert.presentation.ui.components.SinglePetItem
import com.mark.petfinderexpert.presentation.ui.components.SingleTypeItem
import com.mark.petfinderexpert.presentation.ui.navigation.Routes
import com.mark.petfinderexpert.presentation.viewmodel.pets.PetsListViewModel
import com.mark.petfinderexpert.utils.helper.AppHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsListScreen(
    navController: NavController,
    viewModel: PetsListViewModel = hiltViewModel()
) {
    val petsListUIState by viewModel.petTypes.collectAsState()
    Column {
        CenterAlignedTopAppBar(  title = {
            Text(text = stringResource(id = R.string.app_name))
        },   colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor =  colorResource(id = R.color.white),
            titleContentColor = MaterialTheme.colorScheme.primary,
        )
        )
        //List of Categories
        LazyRow {
            items(petsListUIState!!.types.size) { type ->
                SingleTypeItem(
                    type = petsListUIState!!.types.get(type),
                    onItemClick = {

                    viewModel.onEvent(PetListingEvent.onPetGenreSelection(it.name))
                    }
                )
            }
        }
        LazyColumn {
            items(petsListUIState.pets.size) { pet ->
                SinglePetItem(
                    animal = petsListUIState.pets.get(pet),
                    onItemClick = {
                        AppHelper.selectedPet=it
                        navController.navigate(Routes.PetDetailScreen.route)
                    }
                )
            }
        }

    }
}


