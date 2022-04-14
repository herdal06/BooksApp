package com.herdal.booksapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.herdal.booksapp.R
import com.herdal.booksapp.adapter.BookAdapter
import com.herdal.booksapp.model.Author
import com.herdal.booksapp.model.Book
import com.herdal.booksapp.model.Category
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    private lateinit var bookList: ArrayList<Book>
    private lateinit var bookAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val category = intent.getSerializableExtra("category") as Category

        toolbarBooks.title = "Books : ${category.name}"
        setSupportActionBar(toolbarBooks)

        recyclerViewBooks.setHasFixedSize(true)
        recyclerViewBooks.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        bookList = ArrayList()

        val c = Category(1,"Drama")
        val a = Author(1,"Tolstoy")

        val b1 = Book(1,"Anna Karenina",1860,"",c,a)
        val b2 = Book(2,"LOTR",1956,"",c,a)
        val b3 = Book(3,"Dune",1972,"",c,a)

        bookList.add(b1)
        bookList.add(b2)
        bookList.add(b3)

        bookAdapter = BookAdapter(this,bookList)
        recyclerViewBooks.adapter = bookAdapter
    }
}