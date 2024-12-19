package com.example.pr5.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pr5.R
import com.example.pr5.data.ProductEntity

class ProductAdapter(private var products: List<ProductEntity>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.productTitle)
        val description: TextView = itemView.findViewById(R.id.productDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.title.text = product.title
        holder.description.text = product.description
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun updateProducts(newProducts: List<ProductEntity>) {
        products = newProducts
        notifyDataSetChanged()
    }
}
