package com.dawinder.customshapes_jc.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Custom [Shape] implementation representing the shape of a hexagon.
 *
 * The hexagon shape is created using a [Path] with lines connecting its points based
 * on the provided [size] of the hexagon.
 */
class HexagonShape : Shape {

    /**
     * Creates the [Outline] for the hexagon shape.
     *
     * @param size The [Size] of the hexagon.
     * @param layoutDirection The [LayoutDirection] of the hexagon.
     * @param density The [Density] of the hexagon.
     * @return The [Outline] representing the hexagon shape.
     */
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawCustomHexagonPath(size)
        )
    }
}

/**
 * Draws the path for the hexagon shape.
 *
 * @param size The [Size] of the hexagon.
 * @return The [Path] representing the hexagon shape.
 */
private fun drawCustomHexagonPath(size: Size): Path {
    return Path().apply {
        val radius = min(size.width / 2f, size.height / 2f)
        val triangleHeight = (sqrt(3.0) * radius / 2)
        val centerX = size.width / 2
        val centerY = size.height / 2

        moveTo(x = centerX, y = centerY + radius)
        lineTo(x = (centerX - triangleHeight).toFloat(), y = centerY + radius / 2)
        lineTo(x = (centerX - triangleHeight).toFloat(), y = centerY - radius / 2)
        lineTo(x = centerX, y = centerY - radius)
        lineTo(x = (centerX + triangleHeight).toFloat(), y = centerY - radius / 2)
        lineTo(x = (centerX + triangleHeight).toFloat(), y = centerY + radius / 2)

        close()
    }
}