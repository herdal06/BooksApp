package com.herdal.booksapp.service

import android.annotation.SuppressLint
import com.herdal.booksapp.model.Author
import com.herdal.booksapp.model.Book
import com.herdal.booksapp.model.Category

class BookDao {
    @SuppressLint("Range")
    fun getAllBooksByCategoryId(dbHelper: DatabaseHelper, categoryId: Int) : ArrayList<Book> {
        val bookList = ArrayList<Book>()
        val db = dbHelper.writableDatabase
        val c = db.rawQuery("SELECT * FROM category,author,book WHERE book.category_id = category.id AND book.author_id= author.id AND book.category_id= $categoryId",null)

        while(c.moveToNext()) {
            val category = Category(
                c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("name")))
            val author = Author(
                c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("name")))
            val book = Book(
                c.getInt(c.getColumnIndex("id"))
                ,c.getString(c.getColumnIndex("name"))
                ,c.getInt(c.getColumnIndex("releaseDate"))
                ,c.getString(c.getColumnIndex("image"))
                ,category
                ,author
            )

            bookList.add(book)
        }

        return bookList
    }
}