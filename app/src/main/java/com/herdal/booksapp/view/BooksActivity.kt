package com.herdal.booksapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.herdal.booksapp.R
import com.herdal.booksapp.adapter.BookAdapter
import com.herdal.booksapp.model.Author
import com.herdal.booksapp.model.Book
import com.herdal.booksapp.model.Category
import com.herdal.booksapp.service.BookDao
import com.herdal.booksapp.service.DatabaseHelper
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    private lateinit var bookList: ArrayList<Book>
    private lateinit var bookAdapter: BookAdapter

    private lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val category = intent.getSerializableExtra("category") as Category

        toolbarBooks.title = "Books : ${category.name}"
        setSupportActionBar(toolbarBooks)

        recyclerViewBooks.setHasFixedSize(true)
        recyclerViewBooks.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        dbHelper = DatabaseHelper(this)

        bookList = BookDao().getAllBooksByCategoryId(dbHelper,category.id)

        bookAdapter = BookAdapter(this,bookList)
        recyclerViewBooks.adapter = bookAdapter
    }
}