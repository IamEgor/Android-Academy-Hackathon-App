package com.academy.hackathonapp.data.network

import com.academy.hackathonapp.data.ResponseWrapper
import com.academy.hackathonapp.data.model.Users
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("ExRates/Rates/145")
    suspend fun getUsdToday(): ResponseWrapper<Any>


    @GET("5dcc147154000059009c2104")
    suspend fun getUsersError(
        @Query("page") page: Int
    ): ResponseWrapper<Users>
}