package com.herdal.booksapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.herdal.booksapp.R
import com.herdal.booksapp.model.Book
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.books_card_view.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val book = intent.getSerializableExtra("book") as Book

        textViewBookDetails.text = book.name
        textViewBookReleaseDate.text = (book.releaseDate).toString()
        textViewBookAuthor.text = book.author.name

        imageViewDetail.setImageResource(
            resources.getIdentifier(book.image,"drawable",packageName))

    }
}