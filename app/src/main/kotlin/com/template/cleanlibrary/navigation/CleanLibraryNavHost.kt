package com.template.cleanlibrary.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import timber.log.Timber

@Composable
fun CleanLibraryNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MAIN_GRAPH_ROUTE,
        builder = {
            mainNavGraph(navController)
        }
    )

    LaunchedEffect(Unit) {
        navController.currentBackStack.collect {
            Timber.d(navController.currentBackStack.value.map { it.destination.route }.joinToString())
        }
    }
}