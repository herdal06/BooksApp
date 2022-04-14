package com.herdal.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.herdal.booksapp.model.Category
import com.herdal.booksapp.service.CategoryAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var categoryList: ArrayList<Category>
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarCategory.title = "Categories"
        setSupportActionBar(toolbarCategory)

        recyclerViewCategories.setHasFixedSize(true)
        recyclerViewCategories.layoutManager = LinearLayoutManager(this)

        categoryList = ArrayList()
        val c1 = Category(1,"Novel")
        val c2 = Category(2,"Poem")
        val c3 = Category(3,"Science Fiction")
        val c4 = Category(4,"History")
        val c5 = Category(5,"Horror")
        val c6 = Category(5,"Fantastic Fiction")

        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c4)
        categoryList.add(c5)
        categoryList.add(c6)

    }
}