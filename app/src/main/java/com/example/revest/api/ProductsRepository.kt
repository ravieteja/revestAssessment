package com.example.revest.api

import com.example.revest.common.models.ProductResponseModel
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val apiService: ApiInterface) {
    suspend fun getAllProducts(): ArrayList<ProductResponseModel> {
        return try {
           val response=  apiService.getAllProducts()
            return response.products!!
        } catch (e: IOException) {
            arrayListOf()
        } catch (e: HttpException) {
            arrayListOf()
        } catch (e: Exception) {
            arrayListOf()
        }
    }

    suspend fun getProductById(id: Int): ProductResponseModel {
        return try {
            apiService.getProductById(id)
        } catch (e: IOException) {
            ProductResponseModel()
        } catch (e: HttpException) {
            ProductResponseModel()
        } catch (e: Exception) {
            ProductResponseModel()
        }
    }
}