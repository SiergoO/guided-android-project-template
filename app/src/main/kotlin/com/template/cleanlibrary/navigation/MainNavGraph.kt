package com.template.cleanlibrary.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.template.cleanlibrary.feature.authordetails.navigation.navigateToAuthorDetailsScreen
import com.template.cleanlibrary.feature.authordetails.navigation.onAuthorDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.navigation.navigateToBookDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.navigation.onBookDetailsScreen
import com.template.cleanlibrary.feature.bookshelf.navigation.onBookshelfScreen
import com.template.cleanlibrary.feature.library.navigation.LIBRARY_ROUTE
import com.template.cleanlibrary.feature.library.navigation.onLibraryScreen

const val MAIN_GRAPH_ROUTE = "graph_main"

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = LIBRARY_ROUTE,
        route = MAIN_GRAPH_ROUTE
    ) {
        onLibraryScreen(navController::navigateToBookDetailsScreen)
        onBookshelfScreen(navController::navigateToBookDetailsScreen)
        onBookDetailsScreen(navController::navigateToAuthorDetailsScreen)
        onAuthorDetailsScreen()
    }
}