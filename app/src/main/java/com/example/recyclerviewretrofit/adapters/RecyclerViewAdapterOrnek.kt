package com.example.recyclerviewretrofit.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerviewretrofit.ProductDetailsActivity
import com.example.recyclerviewretrofit.R
import com.example.recyclerviewretrofit.models.Product

class RecyclerViewAdapterOrnek(val productList: List<Product>) : RecyclerView.Adapter<RecyclerViewAdapterOrnek.ProductVH>() {
    class ProductVH(view: View) : RecyclerView.ViewHolder(view){
/*
görünüm tutucu yardımcı sınıf
 */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        // Inflater, LayoutInflater, MenuInflater
        // parent demek nerede çalıştırılıyorsa orası demektir
        // attachRooat, ilk açıldığında ne yapması gerektiğinden bahsediyor,
        // ilk açıldığında bağlansın mı bağlanmasın mı
        val itemViewww = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ProductVH(itemViewww)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val rootView = holder.itemView // item view dediğimiz olusturulan her bir sutun

        val productId = rootView.findViewById<TextView>(R.id.productId)
        val productTitle = rootView.findViewById<TextView>(R.id.productTitle)
        val productPrice = rootView.findViewById<TextView>(R.id.productPrice)
        val productStock = rootView.findViewById<TextView>(R.id.productStock)
        val productBrand = rootView.findViewById<TextView>(R.id.productBrand)
        val productImage = rootView.findViewById<TextView>(R.id.productImage)

        val dt = productList.get(position)
        productId.setText("ID: "+dt.id.toString())
        productTitle.setText("TITLE: "+dt.title.toString())
        productPrice.setText("PRICE: "+dt.price.toString())
        productStock.setText("STOCK: "+dt.stock.toString())
        productBrand.setText("BRAND: "+dt.stock.toString())
        productImage.setText("IMAGE: "+dt.images.get(0).toString())

// her olusturulan bir row'a tıklama nasıl olacak
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetailsActivity::class.java)
            intent.putExtra("id", dt.id.toString())
            intent.putExtra("name", dt.title.toString())
            holder.itemView.context.startActivity(intent)

        }

    }


}