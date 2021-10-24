package com.hamelin_menoret.bookshop
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookMiniature(view: View) : RecyclerView.ViewHolder(view)  {
    val image: ImageView = view.findViewById(R.id.image)
    val title: TextView = view.findViewById(R.id.title)
}