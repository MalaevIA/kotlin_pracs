package com.example.pr7

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.pr7.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageHelper: ImageHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageHelper = ImageHelper(this)

        binding.btSave.setOnClickListener { downloadAndSaveFile() }
    }

    private fun downloadAndSaveFile() {
        val url = binding.etUrl.text.toString()
        val filename = binding.etFileName.text.toString()
        if (url.isEmpty() || filename.isEmpty()) return

        CoroutineScope(Dispatchers.Main).launch {
            val image = imageHelper.downloadImage(url)
            image?.let {
                imageHelper.saveImage(it, "$filename.png")
                Toast.makeText(applicationContext, "Image saved", Toast.LENGTH_LONG).show()
             //   Snackbar.make(binding.main, "Image saved", Toast.LENGTH_LONG).show()
                binding.imageView.setImageBitmap(it)
            }
        }
    }
}
