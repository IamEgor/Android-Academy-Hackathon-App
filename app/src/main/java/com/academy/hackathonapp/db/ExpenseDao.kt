package com.academy.hackathonapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.academy.hackathonapp.db.model.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM Expense ORDER BY date DESC")
    fun getAll(): List<Expense>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(expense: Expense)

    @Query("SELECT * FROM Expense WHERE id = :id")
    fun getById(id: Long): Expense?

    @Query("SELECT * FROM Expense WHERE category_id = :categoryId")
    fun getExpenseByCategory(categoryId: Long): List<Expense>

}
