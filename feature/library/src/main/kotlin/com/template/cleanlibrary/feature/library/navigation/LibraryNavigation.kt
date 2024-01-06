package com.template.cleanlibrary.feature.library.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.template.cleanlibrary.feature.library.ui.LibraryRoute

const val LIBRARY_GRAPH_ROUTE = "graph_library"
const val LIBRARY_ROUTE = "route_library"

fun NavController.navigateToLibraryScreen(navOptions: NavOptions) = navigate(LIBRARY_GRAPH_ROUTE, navOptions)

fun NavGraphBuilder.onLibraryScreen(
    onNavigateToBookDetailsScreen: (bookId: String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = LIBRARY_GRAPH_ROUTE,
        startDestination = LIBRARY_ROUTE,
    ) {
        composable(route = LIBRARY_ROUTE) {
            LibraryRoute(onNavigateToBookDetailsScreen = onNavigateToBookDetailsScreen)
        }
        nestedGraphs()
    }
}