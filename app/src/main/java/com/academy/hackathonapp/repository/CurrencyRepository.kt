package com.academy.hackathonapp.repository

import com.academy.hackathonapp.db.CurrencyDao
import com.academy.hackathonapp.db.model.Currency

class CurrencyRepository(private val currencyDao: CurrencyDao) {

    fun getAll(): List<Currency> {
        return currencyDao.getAll()
    }

    fun saveCurrencyList(currenciesList: List<Currency>) {
        return currencyDao.insertAll(currenciesList)
    }
}