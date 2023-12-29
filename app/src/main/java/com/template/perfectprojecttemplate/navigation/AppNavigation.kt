package com.template.perfectprojecttemplate.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.template.first.ui.FirstScreen
import com.template.second.ui.SecondScreen
import timber.log.Timber

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var currentNavDestination: NavDestination by remember { mutableStateOf(NavDestination.Books) }

    LaunchedEffect(Unit) {
        navController.currentBackStack.collect {
            currentNavDestination = NavDestination.getByRoute(navController.currentDestination?.route ?: "")
            Timber.d(navController.currentBackStack.value.map { it.destination.route }.joinToString())
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        NavHost(
            modifier = Modifier.weight(1f),
            navController = navController,
            startDestination = NavDestination.Books.route,
            builder = {
                onBooksScreen(navController)
                onDetailsScreen(navController)
            }
        )
    }
}

private fun NavGraphBuilder.onBooksScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.Books.route
    ) {
        FirstScreen {
            navController.navigate(NavDestination.Details.route)
        }
    }
}

private fun NavGraphBuilder.onDetailsScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.Details.route
    ) {
        SecondScreen()
    }
}
