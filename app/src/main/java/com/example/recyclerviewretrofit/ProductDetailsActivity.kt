package com.example.recyclerviewretrofit

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var txtId : TextView
    private lateinit var txtName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtId = findViewById(R.id.detailId)
        txtName = findViewById(R.id.detailName)
        val extras = intent.extras

        val myId = extras!!.getString("id",null)
        val myName = extras!!.getString("name",null)

        txtId.setText(myId)
        txtName.setText(myName)





    }
}