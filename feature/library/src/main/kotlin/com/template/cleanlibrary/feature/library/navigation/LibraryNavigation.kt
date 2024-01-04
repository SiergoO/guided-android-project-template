package com.template.cleanlibrary.feature.library.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.template.cleanlibrary.feature.library.ui.LibraryRoute

internal const val LIBRARY_ROUTE = "route_library"

fun NavController.navigateToLibraryScreen (navOptions: NavOptions) = navigate(LIBRARY_ROUTE, navOptions)

fun NavGraphBuilder.onLibraryScreen(
    onBookClicked: (bookId: String) -> Unit
) {
    composable(
        route = LIBRARY_ROUTE
    ) {
        LibraryRoute(onBookClicked)
    }
}