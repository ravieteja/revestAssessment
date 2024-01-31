package com.example.revest.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.revest.details.ui.ProductDetails
import com.example.revest.products.ui.ProductsHome
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.revest.products.viewModel.ProductsHomeViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.revest.details.viewModel.ProductDetailsViewModel


@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            val viewModel = hiltViewModel<ProductsHomeViewModel>()
            ProductsHome(navController, viewModel = viewModel)
        }
        composable(
            route = Screens.Detail.route,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            val viewModel = hiltViewModel<ProductDetailsViewModel>()
            ProductDetails(navController, viewModel, productId ?: 0)
        }
    }
}