package com.dawinder.customshapes_jc.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dawinder.customshapes_jc.models.Images
import com.dawinder.customshapes_jc.ui.composables.tabs.DiamondScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.HeartScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.HexagonScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.StarScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.TicketScreen
import com.dawinder.customshapes_jc.ui.nav.Diamond
import com.dawinder.customshapes_jc.ui.nav.Heart
import com.dawinder.customshapes_jc.ui.nav.Hexagon
import com.dawinder.customshapes_jc.ui.nav.Star
import com.dawinder.customshapes_jc.ui.nav.Ticket

/**
 * Composable function to set up the navigation within the app using a NavHost.
 *
 * @param navController The NavHostController that handles navigation within the app.
 * @param modifier The optional [Modifier] to apply custom styling to the NavHost.
 * @param images The list of [Images] representing images to be displayed in different screens.
 */
@Composable
fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    images: List<Images>
) {
    NavHost(
        navController = navController,
        startDestination = Hexagon.route,
        modifier = modifier
    ) {
        // Define composable functions for each screen using their respective routes
        composable(route = Hexagon.route) { HexagonScreen(images) }
        composable(route = Star.route) { StarScreen(images) }
        composable(route = Heart.route) { HeartScreen(images) }
        composable(route = Ticket.route) { TicketScreen(images) }
        composable(route = Diamond.route) { DiamondScreen(images) }
    }
}