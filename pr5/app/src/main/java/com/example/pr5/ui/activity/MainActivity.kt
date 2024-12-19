package com.example.pr5.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pr5.R
import com.example.pr5.data.ProductEntity
import com.example.pr5.retrofit.api.MainApi
import com.example.pr5.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var mainApi: MainApi
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        val b = findViewById<Button>(R.id.button)
        val displayButton = findViewById<Button>(R.id.displayButton)

        b.setOnClickListener {
            viewModel.loadProduct(mainApi, tv)
        }

        displayButton.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            startActivity(intent)
        }
    }
}
