package com.herdal.booksapp.model

import java.io.Serializable

data class Book(
    var id: Int
    ,var name: String
    ,var releaseDate: Int
    ,var image: String
    ,var category: Category
    ,var author: Author) : Serializable {
}