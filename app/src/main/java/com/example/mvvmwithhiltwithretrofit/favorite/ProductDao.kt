package com.example.mvvmwithhiltwithretrofit.favorite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<ProductFav>


    @Query("SELECT * FROM product WHERE isFavorite = 1")
    fun getFavorites(): List<ProductFav>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: ProductFav)

    @Update
    fun update(product: ProductFav)

    @Delete
    fun delete(product: ProductFav)
}
