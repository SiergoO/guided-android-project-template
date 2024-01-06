package com.template.cleanlibrary.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.template.cleanlibrary.navigation.CleanLibraryNavHost

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
            CleanLibraryNavHost(
                modifier = Modifier.weight(1f),
                navController = rememberNavController()
            )
        }
    }
}