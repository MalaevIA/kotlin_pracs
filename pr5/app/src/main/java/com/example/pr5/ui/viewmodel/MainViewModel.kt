package com.example.pr5.ui.viewmodel

import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr5.data.ProductDao
import com.example.pr5.data.ProductEntity
import com.example.pr5.retrofit.api.MainApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productDao: ProductDao
) : ViewModel() {

    fun loadProduct(mainApi: MainApi, tv: TextView) {
        viewModelScope.launch {
            try {
                val randomId = (1..100).random()
                val product = mainApi.getProductById(randomId)
                val productEntity = ProductEntity(
                    product.id,
                    product.title,
                    product.description,
                    product.price,
                    product.category
                )
                productDao.insertProduct(productEntity)
                tv.text = "Product saved: ${product.title}"
            } catch (e: Exception) {
                tv.text = "Error: ${e.message}"
            }
        }
    }
}