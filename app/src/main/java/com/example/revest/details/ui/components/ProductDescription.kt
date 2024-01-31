package com.example.revest.details.ui.components


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.revest.common.ui.RvTextView
import com.example.revest.ui.theme.descriptionStyle

@Composable
fun DetailsDescription(title: String) {
    var showMore by remember { mutableStateOf(true) }
    Column(modifier = Modifier
        .animateContentSize(animationSpec = tween(500))
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) { showMore = !showMore }) {
        // if showMore is true, the Text will expand
        // Else Text will be restricted to 3 Lines
        if (!showMore) {
            RvTextView(
                text = title,
                style = descriptionStyle
            )
        } else {
            RvTextView(
                text = title,
                style = descriptionStyle,
                maxLines = 5,
            )
        }
    }
}