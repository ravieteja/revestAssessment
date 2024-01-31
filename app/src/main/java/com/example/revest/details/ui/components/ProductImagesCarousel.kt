@file:OptIn(ExperimentalPagerApi::class)

package com.example.revest.details.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.revest.R
import com.example.revest.common.ui.RvImageView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProductImagesCarousel(listOfImages: List<String>) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(pagerState.currentPage) {
        delay(3000) // wait for 3 seconds.
        // increasing the position and check the limit
        var newPosition = pagerState.currentPage + 1
        Log.d("TAG", "ProductImagesCarousel: $newPosition")
        if (newPosition >= listOfImages.size) newPosition = 0
        // scrolling to the new position.
        coroutineScope.launch(Dispatchers.Main) {
            pagerState.animateScrollToPage(page = newPosition)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .aspectRatio(4 / 3f)
    ) {
        HorizontalPager(
            count = listOfImages.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                RvImageView(
                    image = listOfImages[pagerState.currentPage], imageDescription = "", modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            Brush.verticalGradient(
                                0F to Color.Transparent,
                                .5F to colorResource(id = R.color.black).copy(alpha = 0.5F),
                                1F to colorResource(id = R.color.black).copy(alpha = 0.8F),
                                startY = 0F,
                                endY = 100F,
                            )
                        )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
//                        .5F to colorResource(id = R.color.black).copy(alpha = 0.5F),
                        1F to colorResource(id = R.color.black).copy(alpha = 0.8F),
                        startY = 0F,
                        endY = 100F,
                    )
                )
        ) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 6.dp, start = 28.dp, end = 28.dp)
                    .background(color = Color.Transparent),
                indicatorShape = RectangleShape,
                indicatorWidth = 8.dp,
                indicatorHeight = 3.dp,
                activeColor = colorResource(id = R.color.white),
                inactiveColor = colorResource(id = R.color.white).copy(alpha = 0.4f)
            )
        }
    }
}