package com.dawinder.customshapes_jc.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/**
 * Custom [Shape] implementation representing the shape of a heart.
 *
 * The heart shape is created using a [Path] with cubic Bezier curves connecting its points
 * based on the provided [size] of the heart.
 */
class HeartShape : Shape {

    /**
     * Creates the [Outline] for the heart shape.
     *
     * @param size The [Size] of the heart.
     * @param layoutDirection The [LayoutDirection] of the heart.
     * @param density The [Density] of the heart.
     * @return The [Outline] representing the heart shape.
     */
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

/**
 * Draws the path for the heart shape.
 *
 * @param size The [Size] of the heart.
 * @return The [Path] representing the heart shape.
 */
private fun drawHeartPath(size: Size): Path {
    return Path().apply {
        val width: Float = size.width
        val height: Float = size.height

        // Starting point
        moveTo(x = width / 2, y = height / 5)

        // Upper left path
        cubicTo(
            x1 = 5 * width / 14, y1 = 0f,
            x2 = 0f, y2 = height / 15,
            x3 = width / 28, y3 = 2 * height / 5
        )

        // Lower left path
        cubicTo(
            x1 = width / 14, y1 = 2 * height / 3,
            x2 = 3 * width / 7, y2 = 5 * height / 6,
            x3 = width / 2, y3 = height
        )

        // Lower right path
        cubicTo(
            x1 = 4 * width / 7, y1 = 5 * height / 6,
            x2 = 13 * width / 14, y2 = 2 * height / 3,
            x3 = 27 * width / 28, y3 = 2 * height / 5
        )

        // Upper right path
        cubicTo(
            x1 = width, y1 = height / 15,
            x2 = 9 * width / 14, y2 = 0f,
            x3 = width / 2, y3 = height / 5
        )

        close()
    }
}