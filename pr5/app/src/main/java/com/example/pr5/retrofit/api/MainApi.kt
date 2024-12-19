package com.example.pr5.retrofit.api

import com.example.pr5.retrofit.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}