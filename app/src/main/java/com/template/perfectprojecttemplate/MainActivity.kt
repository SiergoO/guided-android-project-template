package com.template.perfectprojecttemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.template.perfectprojecttemplate.theme.ApplicationTheme

class MainActivity : ComponentActivity() {

    var showSplashScreen: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        installSplashScreen().setKeepOnScreenCondition {
            showSplashScreen
        }

        setContent {
            ApplicationTheme {
                MainLauncher {
                    showSplashScreen = false
                }
            }
        }
    }
}