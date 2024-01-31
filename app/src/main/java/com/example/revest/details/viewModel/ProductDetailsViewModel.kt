package com.example.revest.details.viewModel

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
class ProductDetailsViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {
    private var _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading
    private var _data = MutableLiveData<ProductResponseModel>()
    val product: LiveData<ProductResponseModel> = _data

    fun getProductDetails(id: Int) {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getProductById(id)
                withContext(Dispatchers.Main) {
                    _data.value = response
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _data.value = ProductResponseModel()
                    _isLoading.value = false
                }
            }
        }
    }

    override fun onCleared() {
        _isLoading.value = false
        _data.value = null
        super.onCleared()
    }
}