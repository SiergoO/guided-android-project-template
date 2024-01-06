package com.template.cleanlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.template.cleanlibrary.theme.ApplicationTheme
import com.template.cleanlibrary.ui.CleanLibraryLauncher

class MainActivity : ComponentActivity() {

    private var showSplashScreen: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().setKeepOnScreenCondition {
            showSplashScreen
        }

        setContent {
            ApplicationTheme {
                showSplashScreen = false
                CleanLibraryLauncher()
            }
        }
    }
}