package com.hamelin_menoret.bookshop

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class BookDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val global: Global = this.applicationContext as Global
        val cart = global.globalCart

        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details)

        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.title)
        val isbn = findViewById<TextView>(R.id.isbn)
        val price = findViewById<TextView>(R.id.price)
        val synopsis = findViewById<TextView>(R.id.synopsis)
        val addToCartbutton = findViewById<Button>(R.id.addToCart)

        val bookTitle = intent.getStringExtra("BOOK_TITLE");
        val bookCover = intent.getStringExtra("BOOK_COVER");
        val bookPrice = intent.getStringExtra("BOOK_PRICE");
        val bookIsbn = intent.getStringExtra("BOOK_ISBN");
        val bookSynopsis = intent.getStringExtra("BOOK_SYNOPSIS");

        title.text = bookTitle
        isbn.text = bookIsbn
        price.text = bookPrice
        synopsis.text = bookSynopsis
        Picasso.get().load(bookCover).into(image)

        if (cart.find { it.equals(bookTitle)} != null) {
            addToCartbutton?.isEnabled = false
            addToCartbutton?.setTextColor(Color.GRAY)
            addToCartbutton?.text = "Le livre est dans votre panier"
        }

        addToCartbutton?.setOnClickListener {
            if(bookTitle != null) {
                cart.add(bookTitle)
                global.globalCart = cart
                addToCartbutton?.isEnabled = false
                addToCartbutton?.setTextColor(Color.GRAY)
                addToCartbutton?.text = "Le livre est dans votre panier"
            }
        }
    }
}