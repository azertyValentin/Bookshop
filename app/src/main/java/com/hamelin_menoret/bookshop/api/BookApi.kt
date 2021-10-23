package com.hamelin_menoret.bookshop.api
import com.hamelin_menoret.bookshop.models.Book
import retrofit2.http.*
import retrofit2.Response

interface BookApi {
    @GET("books")
    suspend fun getBooks() : Response<Array<Book>>
}