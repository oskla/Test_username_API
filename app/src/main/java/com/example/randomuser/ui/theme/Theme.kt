package com.example.randomuser.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = notWhite,
    primaryVariant = dkGrey,
    secondary = ltGrey,
    onBackground = notWhite,
    background = notBlack,
    surface = darkerGrey,
    secondaryVariant = yellow
)

private val LightColorPalette = lightColors(
    primary = notBlack,
    primaryVariant = dkGrey,
    secondary = ltGrey,
    onBackground = notBlack,
    background = Color.White,
    surface = notWhite,
    secondaryVariant = yellow

    /* Other default colors to override

    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun randomuserTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
