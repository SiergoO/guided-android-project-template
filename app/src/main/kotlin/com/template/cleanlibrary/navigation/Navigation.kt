package com.template.cleanlibrary.navigation

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
import com.template.cleanlibrary.feature.library.navigation.onLibraryScreen
import com.template.cleanlibrary.feature.second.navigation.navigateToBookDetailsScreen
import com.template.cleanlibrary.feature.second.navigation.onBookDetailsScreen
import timber.log.Timber

@Composable
fun Navigation() {
    val navController = rememberNavController()
    var currentNavDestination: NavDestination by remember { mutableStateOf(NavDestination.Library) }

    LaunchedEffect(Unit) {
        navController.currentBackStack.collect {
            currentNavDestination = NavDestination.getByRoute(navController.currentDestination?.route)
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
            startDestination = NavDestination.Library.route,
            builder = {
                onLibraryScreen(navController::navigateToBookDetailsScreen)
                onBookDetailsScreen()
                onAuthorDetailsScreen(navController)
                onBookshelfScreen(navController)
            }
        )
    }
}


private fun NavGraphBuilder.onAuthorDetailsScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.AuthorDetails.route
    ) {
        // TODO("Add author details composable screen")
    }
}

private fun NavGraphBuilder.onBookshelfScreen(
    navController: NavController
) {
    composable(
        route = NavDestination.Bookshelf.route
    ) {
        // TODO("Add bookshelf composable screen")
    }
}