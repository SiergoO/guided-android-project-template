package com.template.cleanlibrary.feature.second.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.template.cleanlibrary.feature.second.ui.SecondScreen

internal const val BOOK_DETAILS_ROUTE = "route_book_details_screen"

fun NavController.navigateToBookDetailsScreen(bookId: String) = navigate(BOOK_DETAILS_ROUTE)

fun NavGraphBuilder.onBookDetailsScreen() {
    composable(
        route = BOOK_DETAILS_ROUTE
    ) {
        SecondScreen()
    }
}