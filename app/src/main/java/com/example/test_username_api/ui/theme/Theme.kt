package com.example.test_username_api.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = notWhite,
    primaryVariant = dkGrey,
    secondary = Teal200,
    onBackground = notWhite,
    background = notBlack,
    surface = darkerGrey
)

private val LightColorPalette = lightColors(
    primary = notBlack,
    primaryVariant = dkGrey,
    secondary = Teal200,
    onBackground = notBlack,
    background = Color.White,
    surface = notWhite,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Test_username_APITheme(
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