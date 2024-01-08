package com.template.cleanlibrary.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.template.cleanlibrary.core.ui.components.BottomNavigationBar
import com.template.cleanlibrary.core.ui.components.BottomNavigationBarItem
import com.template.cleanlibrary.navigation.CleanLibraryNavHost
import com.template.cleanlibrary.navigation.TopLevelDestination
import com.template.cleanlibrary.navigation.getCurrentTopLevelDestination
import com.template.cleanlibrary.navigation.navigateToTopLevelDestination

@Composable
fun CleanLibraryLauncher() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            val navController = rememberNavController()

            CleanLibraryNavHost(
                modifier = Modifier.weight(1f),
                navController = navController
            )

            CleanLibraryBottomBar(
                navController = navController,
                topLevelDestinations = TopLevelDestination.entries,
                onNavigateToDestination = { destination -> navController.navigateToTopLevelDestination(destination) }
            )
        }
    }
}

@Composable
private fun CleanLibraryBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    topLevelDestinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
) {
    BottomNavigationBar(
        modifier = modifier
    ) {

        topLevelDestinations.forEach { destination ->
            BottomNavigationBarItem(
                modifier = Modifier,
                selected = destination == navController.getCurrentTopLevelDestination(),
                onClick = {
                    onNavigateToDestination(destination)
                },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}