package com.academy.hackathonapp.dependency

import androidx.room.Room
import com.academy.hackathonapp.App
import com.academy.hackathonapp.repository.CategoryRepository
import com.academy.hackathonapp.repository.CurrencyRepository
import com.academy.hackathonapp.repository.ExpenseRepository
import com.example.myapplication.db.AppDatabase

object DataStorage {
    val database by lazy {
        createDatabase()
    }

    private fun createDatabase(): AppDatabase {
        return Room.databaseBuilder(
            App.instance,
            AppDatabase::class.java, "financial_assistant.db"
        ).build()
    }

    fun createCategoryRepository(): CategoryRepository {
        return CategoryRepository(database.categoryDao())
    }

    fun createExpenseRepository(): ExpenseRepository {
        return ExpenseRepository(database.expenseDao())
    }

    fun creteCurrencyRepository(): CurrencyRepository {
        return CurrencyRepository(database.currencyDao())
    }


}