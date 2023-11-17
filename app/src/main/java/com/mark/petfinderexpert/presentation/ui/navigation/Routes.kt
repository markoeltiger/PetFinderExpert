package com.mark.petfinderexpert.presentation.ui.navigation

sealed class Routes(val route: String) {
    object PetsListScreen: Routes("pets_list_screen")
    object PetDetailScreen: Routes("pet_detail_screen")
}
