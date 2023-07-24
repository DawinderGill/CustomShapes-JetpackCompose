package com.dawinder.customshapes_jc.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class DiamondShape : Shape {
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

private fun drawDiamondPath(size: Size): Path {
    return Path().apply {
        val centerX = size.width / 2f
        val diamondCurve = 60f
        val width = size.width
        val height = size.height

        moveTo(0f + diamondCurve, 0f)
        lineTo(width - diamondCurve, 0f)
        lineTo(width, diamondCurve)
        lineTo(centerX, height)
        lineTo(0f, diamondCurve)
        close()
    }
}