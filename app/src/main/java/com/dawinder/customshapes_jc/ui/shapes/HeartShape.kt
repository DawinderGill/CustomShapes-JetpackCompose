package com.dawinder.customshapes_jc.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class HeartShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawHeartPath(size)
        )
    }
}

private fun drawHeartPath(size: Size): Path {
    return Path().apply {
        val width: Float = size.width
        val height: Float = size.height

        // Starting point
        moveTo(width / 2, height / 5)

        // Upper left path
        cubicTo(
            5 * width / 14, 0f,
            0f, height / 15,
            width / 28, 2 * height / 5
        )

        // Lower left path
        cubicTo(
            width / 14, 2 * height / 3,
            3 * width / 7, 5 * height / 6,
            width / 2, height
        )

        // Lower right path
        cubicTo(
            4 * width / 7, 5 * height / 6,
            13 * width / 14, 2 * height / 3,
            27 * width / 28, 2 * height / 5
        )

        // Upper right path
        cubicTo(
            width, height / 15,
            9 * width / 14, 0f,
            width / 2, height / 5
        )

        close()
    }
}