package com.hamelin_menoret.bookshop.models
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Book(
    val isbn: String,
    val title: String,
    val price: Int,
    val cover: String,
    val synopsis: ArrayList<String>
) : Parcelable {
}