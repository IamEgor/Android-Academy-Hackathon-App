package com.academy.hackathonapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.academy.hackathonapp.db.model.Currency
import com.academy.hackathonapp.db.model.Expense
import com.example.myapplication.data.Category

@Database(
    entities = [Category::class, Expense::class, Currency::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TestDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun currencyDao(): CurrencyDao
}