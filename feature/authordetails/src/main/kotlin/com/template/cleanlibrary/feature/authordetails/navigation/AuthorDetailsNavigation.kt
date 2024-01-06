package com.template.cleanlibrary.feature.authordetails.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.template.cleanlibrary.feature.authordetails.ui.AuthorDetailsRoute
import java.net.URLDecoder
import java.net.URLEncoder

internal const val AUTHOR_DETAILS_ROUTE = "route_author_details"
internal const val AUTHOR_ID_ARG = "authorId"

internal class AuthorArgs(val authorId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        URLDecoder.decode(
            checkNotNull(savedStateHandle[AUTHOR_ID_ARG]),
            Charsets.UTF_8.name()
        )
    )
}

fun NavController.navigateToAuthorDetailsScreen(authorId: String) {
    val encodedBookId = URLEncoder.encode(authorId, Charsets.UTF_8.name())
    navigate("$AUTHOR_DETAILS_ROUTE/$encodedBookId")
}

fun NavGraphBuilder.onAuthorDetailsScreen() {
    composable(
        route = "$AUTHOR_DETAILS_ROUTE/{$AUTHOR_ID_ARG}",
        arguments = listOf(
            navArgument(AUTHOR_ID_ARG) { type = NavType.StringType },
        ),
    ) {
        AuthorDetailsRoute()
    }
}