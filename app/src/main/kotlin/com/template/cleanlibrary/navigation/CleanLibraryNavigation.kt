package com.template.cleanlibrary.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.template.cleanlibrary.feature.bookshelf.navigation.navigateToBookshelfScreen
import com.template.cleanlibrary.feature.library.navigation.navigateToLibraryScreen

fun NavController.navigateToBottomNavDestination(bottomNavDestination: BottomNavDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(this@navigateToBottomNavDestination.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when re-selecting a previously selected item
            restoreState = true
        }

        when (bottomNavDestination) {
            BottomNavDestination.LIBRARY -> navigateToLibraryScreen(topLevelNavOptions)
            BottomNavDestination.BOOKSHELF -> navigateToBookshelfScreen(topLevelNavOptions)
        }
}

internal fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNavDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

@Composable
internal fun NavController.getCurrentBottomNavDestination() = this.currentBackStackEntryAsState().value?.destination