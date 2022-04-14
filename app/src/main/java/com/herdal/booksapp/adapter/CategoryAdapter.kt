package com.herdal.booksapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.herdal.booksapp.R
import com.herdal.booksapp.model.Category

class CategoryAdapter(private val context: Context, private val categoryList: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CardViewHolder>(){
    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var card_view_category_name: CardView
        var textViewCategoryName: TextView

        init {
            card_view_category_name = view.findViewById(R.id.card_view_category_name)
            textViewCategoryName = view.findViewById(R.id.textViewCategoryName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_card_view,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val category = categoryList.get(position)
        holder.textViewCategoryName.text = category.name
        holder.card_view_category_name.setOnClickListener { // when we click category
            // intent
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}