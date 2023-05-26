package com.template.perfectprojecttemplate.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.template.presentation.FirstScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String = NavDestination.First.destination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        onFirstScreen(navController)
    }
}

private fun NavGraphBuilder.onFirstScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.First.destination
    ) {
        FirstScreen("Serg")
    }
}
