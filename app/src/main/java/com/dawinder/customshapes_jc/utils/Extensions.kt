package com.dawinder.customshapes_jc.utils

import androidx.navigation.NavHostController

/**
 * Navigates to a destination with the given [route] using the singleTop navigation pattern.
 *
 * The singleTop navigation pattern ensures that if the destination is already at the top of the
 * back stack, it will not be recreated and re-entered. Instead, the existing instance of the
 * destination will be used and its state will be restored if needed.
 *
 * @param route The route identifier for the destination to navigate to.
 */
fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(route) { saveState = true }
        launchSingleTop = true
    }