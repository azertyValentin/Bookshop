package com.hamelin_menoret.bookshop

import android.view.LayoutInflater
import com.hamelin_menoret.bookshop.models.Book
import androidx.recyclerview.widget.RecyclerView.Adapter
import android.view.ViewGroup
import com.squareup.picasso.Picasso

class BookAdapter(val books: Array<Book>): Adapter<BookMiniature>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookMiniature {
        val book = LayoutInflater.from(parent.context).inflate(R.layout.book_miniature, parent, false)
        return BookMiniature(book, null)
    }

    override fun onBindViewHolder(book: BookMiniature, pos: Int) {
        Picasso.get().load(books[pos].cover).into(book.image)
        book.title.text = books[pos].title
        book.book = books[pos]
    }

    override fun getItemCount(): Int {
        return books.size
    }
}