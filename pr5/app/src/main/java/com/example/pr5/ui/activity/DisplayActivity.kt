package com.example.pr5.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pr5.R
import com.example.pr5.ui.adapter.ProductAdapter
import com.example.pr5.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayActivity : AppCompatActivity() {

    private lateinit var adapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.products.observe(this) { products ->
            adapter.updateProducts(products)
        }
    }
}