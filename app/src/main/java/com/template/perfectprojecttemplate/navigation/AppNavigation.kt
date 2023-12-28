package com.template.perfectprojecttemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.template.first.ui.FirstScreen
import com.template.second.ui.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = NavDestination.First.destination,
        builder = {
            onFirstScreen(navController)
            onSecondScreen(navController)
        }
    )
}

private fun NavGraphBuilder.onFirstScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.First.destination
    ) {
        FirstScreen {
            navController.navigate(NavDestination.Second.destination)
        }
    }
}

private fun NavGraphBuilder.onSecondScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.Second.destination
    ) {
        SecondScreen()
    }
}
