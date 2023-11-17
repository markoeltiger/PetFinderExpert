package com.mark.petfinderexpert.presentation.ui.petslist


import androidx.compose.foundation.layout.Column
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
import com.mark.petfinderexpert.presentation.viewmodel.pets.PetsListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsListScreen(
    navController: NavController,
    viewModel: PetsListViewModel = hiltViewModel()
) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        Button(onClick = { viewModel.getToken() }) {
        }
    }
}


