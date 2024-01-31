package com.example.revest.details.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.revest.common.ui.RvTextView
import com.example.revest.R
import com.example.revest.ui.theme.descriptionStyle

@Composable
fun ProductUnavailable() {
    RvTextView(text = stringResource(id = R.string.unavailable), style = descriptionStyle)
}