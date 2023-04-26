package com.example.mvvmwithhiltwithretrofit.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductFav(
    @PrimaryKey val id: String,
    val title: String,
    val brand: String,
    val imageURL: String,
    var isFavorite: Boolean = false
)