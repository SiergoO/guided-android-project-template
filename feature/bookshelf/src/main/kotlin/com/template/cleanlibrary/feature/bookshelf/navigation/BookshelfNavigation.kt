package com.template.cleanlibrary.feature.bookshelf.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.template.cleanlibrary.feature.bookshelf.ui.BookshelfRoute

const val BOOKSHELF_ROUTE = "route_bookshelf"

fun NavController.navigateToBookshelfScreen (navOptions: NavOptions) = navigate(BOOKSHELF_ROUTE, navOptions)

fun NavGraphBuilder.onBookshelfScreen(
    onBookClicked: (bookId: String) -> Unit
) {
    composable(
        route = BOOKSHELF_ROUTE
    ) {
        BookshelfRoute(onBookClicked)
    }
}