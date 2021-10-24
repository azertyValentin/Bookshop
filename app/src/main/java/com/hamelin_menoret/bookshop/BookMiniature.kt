package com.hamelin_menoret.bookshop
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hamelin_menoret.bookshop.models.Book

class BookMiniature(view: View, var book: Book?) : RecyclerView.ViewHolder(view),  View.OnClickListener  {
    val image: ImageView = view.findViewById(R.id.image)
    val title: TextView = view.findViewById(R.id.title)
    private val context: Context = view.context

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(context, BookDetails::class.java)
        intent.putExtra("BOOK_TITLE",this.book?.title)
        intent.putExtra("BOOK_COVER",this.book?.cover)
        intent.putExtra("BOOK_PRICE",this.book?.price.toString())
        intent.putExtra("BOOK_ISBN",this.book?.isbn)
        intent.putExtra("BOOK_SYNOPSIS", this.book?.synopsis?.get(0))
        context.startActivity(intent)
    }
}