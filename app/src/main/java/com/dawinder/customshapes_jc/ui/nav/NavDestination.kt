package com.dawinder.customshapes_jc.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Hexagon
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

interface NavDestination {
    val icon: ImageVector
    val route: String
}

object Hexagon : NavDestination {
    override val icon = Icons.Filled.Hexagon
    override val route = "hexagon"
}

object Star : NavDestination {
    override val icon = Icons.Filled.Star
    override val route = "star"
}

object Heart : NavDestination {
    override val icon = Icons.Filled.HeartBroken
    override val route = "heart"
}

val tabRowScreens = listOf(Hexagon, Star, Heart)