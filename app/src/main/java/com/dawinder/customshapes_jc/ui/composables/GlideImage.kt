package com.dawinder.customshapes_jc.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dawinder.customshapes_jc.R

/**
 * Composable function to display an image using GlideImage.
 *
 * @param url The URL of the image to be displayed.
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemImage(url: String) {
    GlideImage(
        model = url,
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = R.string.item_image)
    )
}