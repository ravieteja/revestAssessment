package com.example.revest.products.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.revest.api.ProductsRepository
import com.example.revest.common.models.ProductResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsHomeViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {
    private var _isLoading = MutableLiveData<Boolean>()
    private var _data = MutableLiveData<ArrayList<ProductResponseModel>>()
    val listOfProducts: LiveData<ArrayList<ProductResponseModel>> = _data
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getAllProducts()
                withContext(Dispatchers.Main) {
                    _data.value = response
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _data.value = arrayListOf()
                    _isLoading.value = false
                }
            }
        }
    }
}