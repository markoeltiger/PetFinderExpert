package com.mark.petfinderexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mark.petfinderexpert.presentation.ui.navigation.Routes
import com.mark.petfinderexpert.presentation.ui.petdetails.PetDetailsScreen
import com.mark.petfinderexpert.presentation.ui.petslist.PetsListScreen
import com.mark.petfinderexpert.presentation.ui.theme.PetFinderExpertTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetFinderExpertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Routes.PetsListScreen.route
                    ) {
                        composable(
                            route = Routes.PetsListScreen.route
                        ) {
                            PetsListScreen(navController)
                        }
                        composable(
                            route = Routes.PetDetailScreen.route
                        ) {
                            PetDetailsScreen(navController)

                        }


                    }
                }
            }
        }
    }
}


