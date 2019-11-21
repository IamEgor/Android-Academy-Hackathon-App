package com.academy.hackathonapp.data.network

import com.academy.hackathonapp.data.ResponseWrapper
import retrofit2.http.GET

interface ApiGoogle {

    @GET("drive/v3/files")
    suspend fun getFiles(): ResponseWrapper<Any>
}