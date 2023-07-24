package com.dawinder.customshapes_jc.ui.composables.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dawinder.customshapes_jc.models.Images
import com.dawinder.customshapes_jc.ui.composables.ItemImage
import com.dawinder.customshapes_jc.ui.shapes.TicketShape
import com.dawinder.customshapes_jc.ui.theme.md_theme_light_primary

@Composable
fun TicketScreen(images: List<Images>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 16.dp)
    ) {
        items(images) {
            Ticket(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), it.url
            )
            Spacer(Modifier.size(16.dp))
        }
    }
}

@Composable
fun Ticket(modifier: Modifier = Modifier, url: String) {
    Box(
        modifier = modifier
            .clip(TicketShape())
            .background(md_theme_light_primary),
        contentAlignment = Alignment.Center
    ) {
        ItemImage(url = url)
    }
}