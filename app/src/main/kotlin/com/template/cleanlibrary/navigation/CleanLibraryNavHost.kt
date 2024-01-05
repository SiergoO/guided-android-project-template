package com.template.cleanlibrary.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.template.cleanlibrary.feature.authordetails.navigation.onAuthorDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.navigation.navigateToBookDetailsScreen
import com.template.cleanlibrary.feature.bookdetails.navigation.onBookDetailsScreen
import com.template.cleanlibrary.feature.bookshelf.navigation.onBookshelfScreen
import com.template.cleanlibrary.feature.library.navigation.LIBRARY_ROUTE
import com.template.cleanlibrary.feature.library.navigation.onLibraryScreen
import timber.log.Timber

@Composable
fun CleanLibraryNavHost(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {

        LaunchedEffect(Unit) {
            navController.currentBackStack.collect {
                Timber.d(navController.currentBackStack.value.map { it.destination.route }.joinToString())
            }
        }

        NavHost(
            modifier = Modifier.weight(1f),
            navController = navController,
            startDestination = LIBRARY_ROUTE,
            builder = {
                onLibraryScreen(navController::navigateToBookDetailsScreen)
                onBookDetailsScreen()
                onAuthorDetailsScreen()
                onBookshelfScreen(navController::navigateToBookDetailsScreen)
            }
        )
    }
}