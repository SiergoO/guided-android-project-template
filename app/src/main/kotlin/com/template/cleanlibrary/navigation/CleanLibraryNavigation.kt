package com.template.cleanlibrary.navigation

import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.template.cleanlibrary.feature.bookshelf.navigation.navigateToBookshelfScreen
import com.template.cleanlibrary.feature.library.navigation.navigateToLibraryScreen

fun NavController.navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(this@navigateToTopLevelDestination.graph.id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when re-selecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.LIBRARY -> navigateToLibraryScreen(topLevelNavOptions)
            TopLevelDestination.BOOKSHELF -> navigateToBookshelfScreen(topLevelNavOptions)
        }
}

internal fun NavController.getCurrentTopLevelDestination() =
    TopLevelDestination.entries.find { dest ->
        currentBackStack.value.any {
            it.destination.route.toString().contains(dest.name.lowercase(), false)
        }
    } ?: TopLevelDestination.LIBRARY