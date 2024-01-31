package com.example.revest.details.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.revest.R
import com.example.revest.common.ui.RvAppBar
import com.example.revest.common.ui.RvProgressLoader
import com.example.revest.common.ui.RvTextView
import com.example.revest.details.ui.components.DetailsDescription
import com.example.revest.details.ui.components.ProductImagesCarousel
import com.example.revest.details.ui.components.ProductRating
import com.example.revest.details.ui.components.ProductUnavailable
import com.example.revest.details.viewModel.ProductDetailsViewModel
import com.example.revest.ui.theme.categoryStyle
import com.example.revest.ui.theme.priceStyle
import com.example.revest.ui.theme.titleStyle
import com.example.revest.utils.capitalizeWords

@Composable
fun ProductDetails(navController: NavHostController, viewModel: ProductDetailsViewModel, productId: Int) {
    val lazyRowState = rememberLazyListState()
    val isLoading by viewModel.isLoading.observeAsState()
    val productDetails by viewModel.product.observeAsState()
    LaunchedEffect(Unit) {
        viewModel.getProductDetails(productId)

    }
    LazyColumn(modifier = Modifier, state = lazyRowState) {
        item {
            RvAppBar(productDetails?.title ?: "") {
                navController.popBackStack()
            }
        }
        if (isLoading == true) {
            item {
                RvProgressLoader()
            }
        } else {
            productDetails?.let {
                it.images?.let { images -> item { ProductImagesCarousel(images) } }
                it.category?.let { category ->
                    item {
                        Box(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) { RvTextView(category, style = categoryStyle) }
                    }
                }
                it.brand?.let { brand ->
                    item {
                        Box(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                            RvTextView(
                                brand.capitalizeWords(),
                                style = titleStyle.copy(fontSize = 22.sp)
                            )
                        }
                    }
                }
                it.title?.let { title ->
                    item {
                        Box(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) { RvTextView(title.capitalizeWords(), maxLines = 2) }
                    }
                }
                it.stock?.let { stock ->
                    if (stock == 0) {
                        item {
                            Box(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) { ProductUnavailable() }
                        }
                    } else {
                        it.price?.let { price ->
                            item {
                                Box(
                                    Modifier.padding(
                                        horizontal = 8.dp,
                                        vertical = 4.dp
                                    )
                                ) {
                                    Row {
                                        RvTextView(stringResource(id = R.string.total_price), style = priceStyle)
                                        RvTextView(
                                            "$price",
                                            style = if ((it.discountPercentage
                                                    ?: 0.0) > 0.0
                                            ) priceStyle.copy(textDecoration = TextDecoration.LineThrough) else priceStyle
                                        )
                                        it.discountPercentage?.let { discount ->
                                            if (discount > 0) {
                                                RvTextView(" ${String.format("%.2f", price * (1 - (discount / 100.0)))}", style = priceStyle)

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                it.discountPercentage?.let { discount ->
                    if (discount > 0) {
                        item {
                            Box(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                                RvTextView(
                                    "with ${discount}% discount",
                                    style = priceStyle.copy(fontWeight = FontWeight.Medium, fontSize = 12.sp)
                                )
                            }
                        }
                    }
                }
                it.rating?.let { rating ->
                    item {
                        Box(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) { ProductRating(rating = rating) }
                    }
                }
                it.description?.let { description ->
                    item {
                        Box(
                            Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        ) { DetailsDescription(description) }
                    }
                }
            }
        }
    }
}