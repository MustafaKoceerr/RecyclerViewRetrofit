package com.example.recyclerviewretrofit.services

import com.example.recyclerviewretrofit.models.ProductsData
import retrofit2.Call
import retrofit2.http.GET

interface IDummyService {

    @GET("products")
    fun getProducts(): Call<ProductsData>

}