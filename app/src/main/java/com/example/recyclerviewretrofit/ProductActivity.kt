package com.example.recyclerviewretrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewretrofit.adapters.RecyclerViewAdapterOrnek
import com.example.recyclerviewretrofit.configs.ApiClient
import com.example.recyclerviewretrofit.models.ProductsData
import com.example.recyclerviewretrofit.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myRecyclerView = findViewById(R.id.recyclerView)
        val iDummyService = ApiClient.getClient().create(IDummyService::class.java)

        try {
            iDummyService.getProducts().enqueue(object : Callback<ProductsData> {
                override fun onResponse(p0: Call<ProductsData>, p1: Response<ProductsData>) {
                    println("On response'desin")
                    println(p1.body())
                    // datalar geldi, şimdi recycler view'a bağlama sırası

                    p1.body()?.let {
                        val adapter = RecyclerViewAdapterOrnek(p1.body()!!.products)
                        myRecyclerView.adapter = adapter

                        val linearLayoutManager = LinearLayoutManager(applicationContext)
                        linearLayoutManager.orientation = RecyclerView.VERTICAL
                        myRecyclerView.layoutManager = linearLayoutManager

                    }
                }

                override fun onFailure(p0: Call<ProductsData>, p1: Throwable) {
                    println("################ ON FAILURE'A DUSTUNN")
                }
            })
        }
        catch (ex : Exception){
            println("**************CATCH'E YAKALANDIN, ${ex.stackTrace}")
        }


    }
}