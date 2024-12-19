package com.example.pr5.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity): Unit

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<ProductEntity>>
}
