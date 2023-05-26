package com.template.perfectprojecttemplate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.template.perfectprojecttemplate.theme.ApplicationTheme

class MainActivity : ComponentActivity() {

    var keepSplashScreen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        WindowCompat.setDecorFitsSystemWindows(window, false)
//
//        installSplashScreen().setKeepOnScreenCondition {
//            keepSplashScreen
//        }

        setContent {
            ApplicationTheme {
                MainScreen {
                    keepSplashScreen = false
                }
            }
        }


    }
}