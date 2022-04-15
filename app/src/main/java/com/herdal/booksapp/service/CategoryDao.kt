package com.herdal.booksapp.service

import android.annotation.SuppressLint
import com.herdal.booksapp.model.Category

class CategoryDao {
    @SuppressLint("Range")
    fun getAllCategories(dbHelper: DatabaseHelper) : ArrayList<Category> {
        val db = dbHelper.writableDatabase // permission
        val categoryList = ArrayList<Category>()
        val c = db.rawQuery("SELECT * FROM category",null)
        while(c.moveToNext()) {
            val category = Category(
                c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("name")))
            categoryList.add(category)
        }
        return categoryList
    }
}