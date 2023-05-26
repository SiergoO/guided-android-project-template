package com.template.perfectprojecttemplate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.template.perfectprojecttemplate.navigation.AppNavigation
import com.template.perfectprojecttemplate.navigation.NavDestination

@Composable
internal fun MainScreen(onLauncherFinished : () -> Unit) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentColor = MaterialTheme.colorScheme.background
        ) {
            AppNavigation(
                navController = navController,
                startDestination = NavDestination.First.destination
            )
        }
    }
    onLauncherFinished()
}