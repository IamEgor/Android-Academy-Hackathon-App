package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.academy.hackathonapp.db.CategoryDao
import com.academy.hackathonapp.db.Converters
import com.academy.hackathonapp.db.CurrencyDao
import com.academy.hackathonapp.db.ExpenseDao
import com.academy.hackathonapp.db.model.Currency
import com.academy.hackathonapp.db.model.Expense
import com.example.myapplication.data.Category

@Database(
    entities = [Category::class, Expense::class, Currency::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun currencyDao(): CurrencyDao
}