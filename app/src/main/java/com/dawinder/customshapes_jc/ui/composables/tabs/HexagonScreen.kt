package com.dawinder.customshapes_jc.ui.composables.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.dawinder.customshapes_jc.models.Images
import com.dawinder.customshapes_jc.ui.composables.ItemImage
import com.dawinder.customshapes_jc.ui.shapes.HexagonShape
import com.dawinder.customshapes_jc.ui.theme.md_theme_light_inversePrimary

/**
 * Composable function to display a grid of hexagons with images.
 *
 * @param images The list of [Images] representing hexagon images to be displayed.
 */
@Composable
fun HexagonScreen(images: List<Images>) {
    val gridColumns = 3
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = (screenWidth / gridColumns).coerceAtMost(200.dp)

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridColumns),
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(images) { Hexagon(modifier = Modifier.size(itemWidth), it.url) }
    }
}

/**
 * Composable function to display a hexagon with an image.
 *
 * @param modifier The optional [Modifier] to apply custom styling to the hexagon.
 * @param url The URL of the image to be displayed in the hexagon.
 */
@Composable
fun Hexagon(modifier: Modifier = Modifier, url: String) {
    Box(
        modifier = modifier
            .clip(HexagonShape())
            .background(md_theme_light_inversePrimary),
        contentAlignment = Alignment.Center
    ) {
        ItemImage(url = url)
    }
}