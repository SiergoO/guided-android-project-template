package com.template.cleanlibrary.feature.bookdetails.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.template.cleanlibrary.feature.bookdetails.ui.BookDetailsRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

internal const val BOOK_DETAILS_ROUTE = "route_book_details"
internal const val BOOK_ID_ARG = "bookId"

internal class BookArgs(val bookId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        URLDecoder.decode(
            checkNotNull(savedStateHandle[BOOK_ID_ARG]),
            UTF_8.name()
        )
    )
}

fun NavController.navigateToBookDetailsScreen(bookId: String) {
    val encodedBookId = URLEncoder.encode(bookId, UTF_8.name())
    navigate("$BOOK_DETAILS_ROUTE/$encodedBookId")
}

fun NavGraphBuilder.onBookDetailsScreen(
    onNavigateToAuthorDetailsScreen: (authorId: String) -> Unit
) {
    composable(
        route = "$BOOK_DETAILS_ROUTE/{$BOOK_ID_ARG}",
        arguments = listOf(
            navArgument(BOOK_ID_ARG) { type = NavType.StringType },
        ),
    ) {
        BookDetailsRoute(onNavigateToAuthorDetailsScreen = onNavigateToAuthorDetailsScreen)
    }
}