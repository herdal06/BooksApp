package com.herdal.booksapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.herdal.booksapp.R
import com.herdal.booksapp.model.Category
import com.herdal.booksapp.adapter.CategoryAdapter
import com.herdal.booksapp.service.CategoryDao
import com.herdal.booksapp.service.DatabaseCopyHelper
import com.herdal.booksapp.service.DatabaseHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var categoryList: ArrayList<Category>
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyDatabase()

        toolbarCategory.title = "Categories"
        setSupportActionBar(toolbarCategory)

        recyclerViewCategories.setHasFixedSize(true)
        recyclerViewCategories.layoutManager = LinearLayoutManager(this)

        dbHelper = DatabaseHelper(this)

        categoryList = CategoryDao().getAllCategories(dbHelper)

        categoryAdapter = CategoryAdapter(this,categoryList)

        recyclerViewCategories.adapter = categoryAdapter
    }

    fun copyDatabase() {
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}