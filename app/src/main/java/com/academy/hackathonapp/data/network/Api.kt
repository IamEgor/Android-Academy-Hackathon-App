package com.academy.hackathonapp.data.network

import com.academy.hackathonapp.data.network.dto.CurrencyDto
import com.academy.hackathonapp.data.network.dto.CurrencyRate
import retrofit2.http.GET

interface Api {

    @GET("ExRates/Rates/145")
    suspend fun getUsdToday(): CurrencyRate

    @GET("ExRates/Currencies")
    suspend fun getCurrencies(): List<CurrencyDto>
}