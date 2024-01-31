package com.example.revest.api

import com.example.revest.common.models.ProductResponseModel
import com.example.revest.common.models.ProductsResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("products/")
    suspend fun getAllProducts(): ProductsResponseModel

    @GET("products/{productId}")
    suspend fun getProductById(@Path("productId") productId: Int): ProductResponseModel
}