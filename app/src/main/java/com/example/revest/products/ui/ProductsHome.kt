@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.example.revest.products.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.revest.R
import com.example.revest.common.ui.RvProgressLoader
import com.example.revest.common.ui.RvTextView
import com.example.revest.products.ui.components.RvProductItemView
import com.example.revest.products.viewModel.ProductsHomeViewModel
import com.example.revest.utils.Screens

@Composable
fun ProductsHome(navController: NavHostController, viewModel: ProductsHomeViewModel) {
    val listOfProducts by viewModel.listOfProducts.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        stickyHeader {
            TopAppBar(
                modifier = Modifier.shadow(
                    elevation = 5.dp,
                    spotColor = Color.DarkGray,
//                    shape = RoundedCornerShape(10.dp)
                ),
                title = { RvTextView(stringResource(id = R.string.store)) },
            )
        }
        if (isLoading == true) {
            item {
                RvProgressLoader()
            }
        } else {
            listOfProducts?.size?.let {
                items(it) { item ->
                    RvProductItemView(listOfProducts!![item]) {id->
                        navController.navigate(Screens.Detail.createProductDetailRoute(id))
                    }
                }
            }
        }
    }
}