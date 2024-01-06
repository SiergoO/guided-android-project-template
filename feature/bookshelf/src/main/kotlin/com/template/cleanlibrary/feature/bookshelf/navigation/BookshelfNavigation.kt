package com.template.cleanlibrary.feature.bookshelf.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.template.cleanlibrary.feature.bookshelf.ui.BookshelfRoute

const val BOOKSHELF_GRAPH_ROUTE = "graph_bookshelf"
const val BOOKSHELF_ROUTE = "route_bookshelf"

fun NavController.navigateToBookshelfScreen (navOptions: NavOptions) = navigate(BOOKSHELF_GRAPH_ROUTE, navOptions)

fun NavGraphBuilder.onBookshelfScreen(
    onNavigateToBookDetailsScreen: (bookId: String) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = BOOKSHELF_GRAPH_ROUTE,
        startDestination = BOOKSHELF_ROUTE,
    ) {
        composable(
            route = BOOKSHELF_ROUTE
        ) {
            BookshelfRoute(onNavigateToBookDetailsScreen = onNavigateToBookDetailsScreen)
            nestedGraphs()
        }
    }
}