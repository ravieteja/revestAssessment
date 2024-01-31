package com.example.revest.common.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.example.revest.ui.theme.titleStyle

@Composable
fun RvTextView(text: String, style: TextStyle = titleStyle, maxLines: Int = 1, modifier: Modifier = Modifier) {
    Text(text = text, style = style, modifier = modifier, overflow = TextOverflow.Ellipsis, maxLines = maxLines)
}