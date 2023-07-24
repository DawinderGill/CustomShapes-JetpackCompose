package com.dawinder.customshapes_jc.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class StarShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawStarPath(size)
        )
    }
}

private fun drawStarPath(size: Size): Path {
    return Path().apply {
        val numPoints = 5
        val centerX = size.width / 2f
        val centerY = size.height / 2f
        val outerRadius = min(size.width, size.height) / 2f
        val innerRadius = outerRadius / 2.5f // Adjust the inner radius as needed

        val doublePi = 2 * PI
        val angleIncrement = doublePi / numPoints

        var angle = -PI / 2f // Start angle at the top point of the star
        moveTo(
            (centerX + outerRadius * cos(angle)).toFloat(),
            (centerY + outerRadius * sin(angle)).toFloat()
        )

        // Draw the points of the star in the correct sequence
        for (i in 1..numPoints) {
            angle += angleIncrement / 2 // Move to the inner angle first
            lineTo(
                (centerX + innerRadius * cos(angle)).toFloat(),
                (centerY + innerRadius * sin(angle)).toFloat()
            )
            angle += angleIncrement / 2 // Move to the outer angle
            lineTo(
                (centerX + outerRadius * cos(angle)).toFloat(),
                (centerY + outerRadius * sin(angle)).toFloat()
            )
        }

        close()
    }
}