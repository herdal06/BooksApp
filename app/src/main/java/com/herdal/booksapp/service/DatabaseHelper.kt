package com.herdal.booksapp.service

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,"bookdb.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"category\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"name\"\tTEXT\n" +
                ");")
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"author\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"name\"\tTEXT\n" +
                ");")
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"book\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"releaseDate\"\tINTEGER,\n" +
                "\t\"image\"\tTEXT,\n" +
                "\t\"category_id\"\tINTEGER NOT NULL,\n" +
                "\t\"author_id\"\tINTEGER NOT NULL,\n" +
                "\tFOREIGN KEY(\"category_id\") REFERENCES \"category\"(\"id\"),\n" +
                "\tFOREIGN KEY(\"author_id\") REFERENCES \"author\"(\"id\")\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS category")
        db?.execSQL("DROP TABLE IF EXISTS author")
        db?.execSQL("DROP TABLE IF EXISTS book")
        onCreate(db)
    }
}