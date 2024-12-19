package com.example.pr4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val file = File(getExternalFilesDir(null), "photos/date.txt")

        val data = if (file.exists()) {
            file.readLines().sortedDescending()  // Хронологический порядок
        } else {
            listOf("No data available")
        }

        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Явно уведомляем RecyclerView об изменении данных
        adapter.notifyDataSetChanged()
    }
}
