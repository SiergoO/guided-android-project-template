package com.template.cleanlibrary.feature.library.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.template.cleanlibrary.feature.library.presentation.LibraryRoute

const val LIBRARY_ROUTE = "route_library"

fun NavController.navigateToLibraryScreen(navOptions: NavOptions) = navigate(LIBRARY_ROUTE, navOptions)

fun NavGraphBuilder.onLibraryScreen(
    onNavigateToBookDetailsScreen: (bookId: String) -> Unit,
) {
    composable(route = LIBRARY_ROUTE) {
        LibraryRoute(onNavigateToBookDetailsScreen = onNavigateToBookDetailsScreen)
    }
}