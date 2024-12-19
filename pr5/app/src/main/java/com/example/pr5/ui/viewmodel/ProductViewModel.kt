package com.example.pr5.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pr5.data.ProductDao
import com.example.pr5.data.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    productDao: ProductDao
) : ViewModel() {

    val products: LiveData<List<ProductEntity>> = productDao.getAllProducts()
}
