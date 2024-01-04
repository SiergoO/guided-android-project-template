package com.template.cleanlibrary.feature.bookdetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.template.cleanlibrary.feature.bookdetails.ui.BookDetailsRoute

internal const val BOOK_DETAILS_ROUTE = "route_book_details"

fun NavController.navigateToBookDetailsScreen(bookId: String) = navigate(BOOK_DETAILS_ROUTE)

fun NavGraphBuilder.onBookDetailsScreen() {
    composable(
        route = BOOK_DETAILS_ROUTE
    ) {
        BookDetailsRoute()
    }
}