@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.revest.common.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.revest.R
import com.example.revest.ui.theme.titleStyle


@Composable
fun RvAppBar(
    headerTitle: String,
    onBack: () -> Unit,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(id = R.color.white)
        ),
        title = {
            RvTextView(
                text = headerTitle,
                style =  titleStyle,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = stringResource(id = R.string.back),
                modifier = Modifier
                    .height(28.dp)
                    .width(28.dp)
                    .padding(2.dp)
                    .clickable(onClick = onBack)
            )
        },
    )
}