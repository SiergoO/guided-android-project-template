package com.template.cleanlibrary.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

private val DarkColorScheme = darkColorScheme(
    primary = GreekFlagBlue,
    secondary = SheetBlue,
    tertiary = IndigoRed,
    error = HeartRed,
    background = PaleGrey,
    primaryContainer = VeilingBlue,
    secondaryContainer = AquarellePurple,
    tertiaryContainer = LavenderPurple,
    errorContainer = ForgottenPink,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onError = White,
    onBackground = GluonGrey,
    onPrimaryContainer = NavalBlue,
    onSecondaryContainer = CountBlack,
    onTertiaryContainer = BlacklistPurple,
    onErrorContainer = BiltongRed
)

private val LightColorScheme = lightColorScheme(
    primary = BabyBlue,
    secondary = AngelBlue,
    tertiary = PlumPurple,
    error = PeachBudRed,
    background = GluonGrey,
    primaryContainer = BridgeportBlue,
    secondaryContainer = NavyBlue,
    tertiaryContainer = EnglishViolet,
    errorContainer = ChokeCherryRed,
    onPrimary = EffervescentBlue,
    onSecondary = BlueBlack,
    onTertiary = ObsidianLavaBlack,
    onError = ArcaviaRed,
    onBackground = WallflowerWhite,
    onPrimaryContainer = VeilingBlue,
    onSecondaryContainer = AquarellePurple,
    onTertiaryContainer = LavenderPurple,
    onErrorContainer = ForgottenPink
)

@Composable
fun ApplicationTheme(
    dynamicColor: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.apply {
                statusBarColor = Color.Transparent.toArgb()
                navigationBarColor = Color.Transparent.toArgb()
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}