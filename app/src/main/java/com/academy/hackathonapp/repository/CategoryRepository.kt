package com.academy.hackathonapp.repository

import com.academy.hackathonapp.db.CategoryDao
import com.academy.hackathonapp.db.model.Category

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    fun getAllCategories(): List<Category> {
        return categoryDao.getAll()
    }

    fun getAllNameCategories(): List<String> {
        return categoryDao.getAllNames()
    }

    fun addCategory(category: Category) {
        categoryDao.insert(category)
    }

    fun addCategories(categories: List<Category>) {
        categoryDao.insertAll(categories)
    }
}