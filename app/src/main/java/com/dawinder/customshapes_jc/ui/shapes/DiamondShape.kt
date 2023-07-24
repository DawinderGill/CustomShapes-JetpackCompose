package com.dawinder.customshapes_jc.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/**
 * Custom [Shape] implementation representing the shape of a diamond.
 *
 * The diamond shape is created using a [Path] by connecting its points with straight lines
 * based on the provided [size] of the diamond.
 */
class DiamondShape : Shape {

    /**
     * Creates the [Outline] for the diamond shape.
     *
     * @param size The [Size] of the diamond.
     * @param layoutDirection The [LayoutDirection] of the diamond.
     * @param density The [Density] of the diamond.
     * @return The [Outline] representing the diamond shape.
     */
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawDiamondPath(size)
        )
    }
}

/**
 * Draws the path for the diamond shape.
 *
 * @param size The [Size] of the diamond.
 * @return The [Path] representing the diamond shape.
 */
private fun drawDiamondPath(size: Size): Path {
    return Path().apply {
        val centerX = size.width / 2f
        val diamondCurve = 60f
        val width = size.width
        val height = size.height

        moveTo(x = 0f + diamondCurve, y = 0f)
        lineTo(x = width - diamondCurve, y = 0f)
        lineTo(x = width, y = diamondCurve)
        lineTo(x = centerX, y = height)
        lineTo(x = 0f, y = diamondCurve)

        close()
    }
}