package com.academy.hackathonapp.repository

import com.academy.hackathonapp.db.ExpenseDao
import com.academy.hackathonapp.db.model.Expense
import com.academy.hackathonapp.db.model.Category

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    fun getAllCategories(): List<Expense> {
        return expenseDao.getAll()
    }

    fun addExpense(expense: Expense) {
        expenseDao.insert(expense)
    }

    fun getExpense(id: Long) {
        expenseDao.getById(id)
    }

    fun getExpensesByCategory(category: Category): List<Expense> {
        return expenseDao.getExpenseByCategory(category.id)
    }


}