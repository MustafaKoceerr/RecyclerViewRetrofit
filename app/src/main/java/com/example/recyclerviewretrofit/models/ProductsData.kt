package com.example.recyclerviewretrofit.models

data class ProductsData(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
