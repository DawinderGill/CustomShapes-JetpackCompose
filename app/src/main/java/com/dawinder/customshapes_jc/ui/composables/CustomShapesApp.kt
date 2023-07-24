package com.dawinder.customshapes_jc.ui.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dawinder.customshapes_jc.ui.composables.tabs.DiamondScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.HeartScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.HexagonScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.StarScreen
import com.dawinder.customshapes_jc.ui.composables.tabs.TicketScreen
import com.dawinder.customshapes_jc.ui.nav.Diamond
import com.dawinder.customshapes_jc.ui.nav.Heart
import com.dawinder.customshapes_jc.ui.nav.Hexagon
import com.dawinder.customshapes_jc.ui.nav.NavDestination
import com.dawinder.customshapes_jc.ui.nav.Star
import com.dawinder.customshapes_jc.ui.nav.Ticket
import com.dawinder.customshapes_jc.ui.nav.tabRowScreens
import com.dawinder.customshapes_jc.ui.theme.md_theme_light_primary
import java.util.Locale

@Composable
fun CustomShapesApp() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = tabRowScreens.find { it.route == currentDestination?.route } ?: Hexagon

    Scaffold(
        topBar = {
            TabRow(
                allScreens = tabRowScreens,
                onTabSelected = { newScreen ->
                    navController.navigateSingleTopTo(newScreen.route)
                },
                currentScreen = currentScreen,
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}

private val TabHeight = 56.dp
private const val InactiveTabOpacity = 0.60f
private const val TabFadeInAnimationDuration = 150
private const val TabFadeInAnimationDelay = 100
private const val TabFadeOutAnimationDuration = 100

@Composable
fun TabRow(
    allScreens: List<NavDestination>,
    onTabSelected: (NavDestination) -> Unit,
    currentScreen: NavDestination
) {
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        Row(Modifier.selectableGroup()) {
            allScreens.forEach { screen ->
                TabContent(
                    text = screen.route,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
fun TabContent(
    text: String,
    icon: ImageVector,
    onSelected: () -> Unit,
    selected: Boolean
) {
    val color = md_theme_light_primary
    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis = TabFadeInAnimationDelay
        )
    }
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else color.copy(alpha = InactiveTabOpacity),
        animationSpec = animSpec, label = ""
    )
    Row(
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .height(TabHeight)
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = Color.Unspecified
                )
            )
            .clearAndSetSemantics { contentDescription = text }
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = tabTintColor)
        if (selected) {
            Spacer(Modifier.width(12.dp))
            Text(text.uppercase(Locale.getDefault()), color = tabTintColor)
        }
    }
}


@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Hexagon.route,
        modifier = modifier
    ) {
        composable(route = Hexagon.route) { HexagonScreen() }
        composable(route = Star.route) { StarScreen() }
        composable(route = Heart.route) { HeartScreen() }
        composable(route = Ticket.route) { TicketScreen() }
        composable(route = Diamond.route) { DiamondScreen() }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(route) { saveState = true }
        launchSingleTop = true
    }