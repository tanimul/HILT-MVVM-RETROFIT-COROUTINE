package com.example.hilt_mvvm_retrofit_coroutine.data.network

import com.example.hilt_mvvm_retrofit_coroutine.data.models.DataList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RetroInterface {
    @GET("repositories")
    suspend fun getSearchData(@Query("q") query: String): Response<DataList>
}