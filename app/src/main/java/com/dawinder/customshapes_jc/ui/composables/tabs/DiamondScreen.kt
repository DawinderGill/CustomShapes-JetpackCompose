package com.dawinder.customshapes_jc.ui.composables.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.dawinder.customshapes_jc.models.Images
import com.dawinder.customshapes_jc.ui.composables.ItemImage
import com.dawinder.customshapes_jc.ui.shapes.DiamondShape
import com.dawinder.customshapes_jc.ui.theme.md_theme_light_primary

@Composable
fun DiamondScreen(images: List<Images>) {
    val gridColumns = 3
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = (screenWidth / gridColumns).coerceAtMost(200.dp)

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridColumns), // Adjust the number of columns as per your preference
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(images) {
            Diamond(modifier = Modifier.size(itemWidth), it.url)
        }
    }
}

@Composable
fun Diamond(modifier: Modifier = Modifier, url: String) {
    Column(modifier = modifier.padding(all = 8.dp)) {
        Box(
            modifier = modifier
                .clip(DiamondShape())
                .background(md_theme_light_primary),
            contentAlignment = Alignment.Center
        ) {
            ItemImage(url = url)
        }
    }
}