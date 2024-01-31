package com.example.revest.utils

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Detail : Screens("detail/{productId}") {
        fun createProductDetailRoute(productId: Int) = "detail/$productId"
    }
}
