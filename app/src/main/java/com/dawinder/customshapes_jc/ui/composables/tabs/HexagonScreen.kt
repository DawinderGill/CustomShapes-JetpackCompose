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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dawinder.customshapes_jc.models.Images
import com.dawinder.customshapes_jc.ui.composables.ItemImage
import com.dawinder.customshapes_jc.ui.shapes.HexagonShape
import com.dawinder.customshapes_jc.ui.theme.md_theme_light_primary
import com.dawinder.customshapes_jc.viewmodel.SharedViewModel

@Composable
fun HexagonScreen(images: List<Images>) {
    val gridColumns = 3
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = (screenWidth / gridColumns).coerceAtMost(200.dp)

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridColumns), // Adjust the number of columns as per your preference
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(images) { Hexagon(modifier = Modifier.size(itemWidth), it.url) }
    }
}

@Composable
fun Hexagon(modifier: Modifier = Modifier, url: String) {
    Box(
        modifier = modifier
            .clip(HexagonShape())
            .background(md_theme_light_primary),
        contentAlignment = Alignment.Center
    ) {
        ItemImage(url = url)
    }
}