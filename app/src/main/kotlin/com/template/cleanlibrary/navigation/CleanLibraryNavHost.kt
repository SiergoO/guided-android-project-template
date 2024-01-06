package com.template.cleanlibrary.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.template.cleanlibrary.feature.authordetails.navigation.navigateToAuthorDetailsScreen
import com.template.cleanlibrary.feature.authordetails.navigation.onAuthorDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.navigation.navigateToBookDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.navigation.onBookDetailsScreen
import com.template.cleanlibrary.feature.bookshelf.navigation.onBookshelfScreen
import com.template.cleanlibrary.feature.library.navigation.LIBRARY_GRAPH_ROUTE
import com.template.cleanlibrary.feature.library.navigation.onLibraryScreen
import timber.log.Timber

@Composable
fun CleanLibraryNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = LIBRARY_GRAPH_ROUTE,
        builder = {
            onLibraryScreen(
                onNavigateToBookDetailsScreen = navController::navigateToBookDetailsScreen,
                nestedGraphs = {
                    onBookDetailsScreen(navController::navigateToAuthorDetailsScreen)
                    onAuthorDetailsScreen()
                }
            )
            onBookshelfScreen(
                onNavigateToBookDetailsScreen = navController::navigateToBookDetailsScreen,
                nestedGraphs = {
                    onBookDetailsScreen(navController::navigateToAuthorDetailsScreen)
                    onAuthorDetailsScreen()
                }
            )
        }
    )

    LaunchedEffect(Unit) {
        navController.currentBackStack.collect {
            Timber.d(navController.currentBackStack.value.map { it.destination.route }.joinToString())
        }
    }
}