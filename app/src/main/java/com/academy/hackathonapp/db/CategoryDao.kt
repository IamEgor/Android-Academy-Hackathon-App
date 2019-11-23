package com.academy.hackathonapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.academy.hackathonapp.db.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM Category ORDER BY categoryName ASC")
    fun getAll(): List<Category>

    @Query("SELECT categoryName FROM Category ORDER BY categoryName DESC")
    fun getAllNames(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

    @Query("SELECT * FROM Category WHERE id = :id")
    fun getById(id: Long): Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<Category>)

}