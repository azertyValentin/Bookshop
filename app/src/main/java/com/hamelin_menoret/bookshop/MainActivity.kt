package com.hamelin_menoret.bookshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamelin_menoret.bookshop.api.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(IO).launch {
            val response = ApiClient.apiService.getBooks();
            if (response.isSuccessful && response.body() != null) {
                runOnUiThread {
                    val content = response.body()
                    val bookList: RecyclerView = findViewById(R.id.listBooks)
                    val adapter = BookAdapter(content!!)
                    bookList.adapter = adapter
                    bookList.layoutManager = GridLayoutManager(this@MainActivity, 1)
                }
            }
        }
    }
}