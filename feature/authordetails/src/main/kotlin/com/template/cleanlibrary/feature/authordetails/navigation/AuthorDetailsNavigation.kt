package com.template.cleanlibrary.feature.authordetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.template.cleanlibrary.feature.authordetails.ui.AuthorDetailsRoute

internal const val AUTHOR_DETAILS_ROUTE = "route_author_details"

fun NavController.navigateToAuthorDetailsScreen(bookId: String) = navigate(AUTHOR_DETAILS_ROUTE)

fun NavGraphBuilder.onAuthorDetailsScreen() {
    composable(
        route = AUTHOR_DETAILS_ROUTE
    ) {
        AuthorDetailsRoute()
    }
}