package com.dawinder.customshapes_jc.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dawinder.customshapes_jc.ui.nav.Hexagon
import com.dawinder.customshapes_jc.ui.nav.tabRowScreens
import com.dawinder.customshapes_jc.utils.navigateSingleTopTo
import com.dawinder.customshapes_jc.viewmodel.SharedViewModel

/**
 * Main composable function for the CustomShapesApp.
 * This composable displays a custom app that showcases different shapes (Hexagon, Diamond, Heart, etc.)
 * along with their images using Jetpack Compose.
 */
@Composable
fun CustomShapesApp() {

    // Get the ViewModel instance using the viewModel() function from the androidx.lifecycle library
    val viewModel: SharedViewModel = viewModel()
    val images = viewModel.images

    // Set up the NavController for navigation within the app
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    // Determine the current screen based on the currentDestination
    val currentScreen = tabRowScreens.find { it.route == currentDestination?.route } ?: Hexagon

    Scaffold(
        topBar = {
            // Display the TabRow at the top of the app to switch between different screens
            TabRow(
                allScreens = tabRowScreens,
                onTabSelected = { newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)
                },
                currentScreen = currentScreen,
            )
        }
    ) { innerPadding ->
        // Set up the main content of the app using the NavHost composable
        NavigationHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            images = images
        )
    }
}