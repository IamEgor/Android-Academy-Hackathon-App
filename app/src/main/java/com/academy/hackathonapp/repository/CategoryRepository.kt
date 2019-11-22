package com.academy.hackathonapp.repository

import com.academy.hackathonapp.db.CategoryDao
import com.example.myapplication.data.Category

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    fun getAllCategories(): List<Category> {
        return categoryDao.getAll()
    }

    fun addCategory(category: Category) {
        categoryDao.insert(category)
    }

    fun addCategories(categories: List<Category>) {
        categoryDao.insertAll(categories)
    }
}