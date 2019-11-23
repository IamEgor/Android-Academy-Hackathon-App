package com.academy.hackathonapp.repository

import com.academy.hackathonapp.data.network.dto.CurrenciesDto
import com.academy.hackathonapp.data.network.dto.CurrencyDto
import com.academy.hackathonapp.db.model.Currency

class CurrencyMapper {

    fun map(currenciesDto: CurrenciesDto): List<Currency> =
        currenciesDto.currencies.map { map(it) }

    private fun map(currencyDto: CurrencyDto): Currency = Currency(
        name = currencyDto.abbr,
        curID = currencyDto.curID
    )
}