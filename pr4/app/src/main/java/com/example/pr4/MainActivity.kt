package com.example.pr4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.cameraButton).setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        findViewById<Button>(R.id.listButton).setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        }
    }