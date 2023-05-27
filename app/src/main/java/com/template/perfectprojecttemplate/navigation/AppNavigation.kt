package com.template.perfectprojecttemplate.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.template.presentation.ui.FirstScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            onFirstScreen(navController)
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

        }
    }
}
