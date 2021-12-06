package com.codelab.theming.ui.start.theme

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

class Color {
    val Red200 = Color(0xfff297a2)
    val Red300 = Color(0xffea6d7e)

    val Red700 = Color(0xffdd0d3c)
    val Red800 = Color(0xffd00036)
    val Red900 = Color(0xffc20029)

    private val DarkColors = darkColors(
        primary = Red300,
        primaryVariant = Red700,
        onPrimary = Color.Black,
        secondary = Red300,
        onSecondary = Color.Black,
        error = Red200
    )
}