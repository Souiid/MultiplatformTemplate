package com.idrisssouissi.multiplatformtemplate.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Black,
    onPrimary = White,

    secondary = White,
    onSecondary = Black,

    background = White,
    onBackground = Black,

    surface = White,
    onSurface = Black,
    onSurfaceVariant = LightGray,

    error = Red,
    onError = White,

    primaryContainer = Blue,
    onPrimaryContainer = White,

    errorContainer = LightGray,
    onErrorContainer = Red
)

@Composable
fun TTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}