package com.example.revest.details.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.revest.common.ui.RvTextView
import com.example.revest.ui.theme.RatingColor
import com.example.revest.ui.theme.RatingDefaultColor
import com.example.revest.ui.theme.descriptionStyle
import com.example.revest.R
import kotlin.math.roundToInt

@Composable
fun ProductRating(maxRating: Int = 5, rating: Double) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(maxRating) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "$rating ${stringResource(id = R.string.rating)}",
                tint = if (index < rating.roundToInt()) RatingColor else RatingDefaultColor,
                modifier = Modifier
                    .padding(end = 2.dp)
            )
        }
        RvTextView(text = "($rating)", style = descriptionStyle)
    }
}