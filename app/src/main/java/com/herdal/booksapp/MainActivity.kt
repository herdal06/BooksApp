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

    }
}