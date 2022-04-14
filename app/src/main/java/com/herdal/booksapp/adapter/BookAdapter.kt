package com.herdal.booksapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.herdal.booksapp.R
import com.herdal.booksapp.model.Book
import com.herdal.booksapp.view.DetailsActivity

class BookAdapter(private val context: Context, private val bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.CardViewHolder>() {
    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewBook: ImageView
        var textViewBookName: TextView
        var card_view_book: CardView

        init {
            imageViewBook = view.findViewById(R.id.imageViewBook)
            textViewBookName = view.findViewById(R.id.textViewBookName)
            card_view_book = view.findViewById(R.id.card_view_book)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.books_card_view,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val book = bookList.get(position)
        holder.textViewBookName.text = book.name
        holder.imageViewBook.setImageResource(context.resources.getIdentifier(book.image,"drawable",context.packageName))
        holder.card_view_book.setOnClickListener {
            // intent
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("book",book)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}