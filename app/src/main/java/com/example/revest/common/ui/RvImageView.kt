package com.example.revest.common.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.revest.R

@Composable
fun RvImageView(image: String, imageDescription: String, modifier: Modifier = Modifier, alignment: Alignment = Alignment.Center) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .crossfade(durationMillis = 500)
            .error(R.drawable.image_file_error)
            .placeholder(R.drawable.image_placeholder)
            .size(coil.size.Size.ORIGINAL)
            .build(),
        contentDescription = imageDescription,
        contentScale = ContentScale.FillBounds,
        modifier = modifier,
        alignment = alignment,
    )
}