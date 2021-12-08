package com.codelab.theming.ui.start.theme

import androidx.compose.foundation.shape.*
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

class Shape {
    val JetnewsShapes = Shapes(
        small = CutCornerShape(topStart = 8.dp),
        medium = CutCornerShape(topStart = 24.dp),
        large = RoundedCornerShape(8.dp)
    )
}