package com.example.hilt_mvvm_retrofit_coroutine.di.module

import com.example.hilt_mvvm_retrofit_coroutine.data.network.RetroInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    private val baseUrl = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getRetrofitInterfaceInstance(retrofit: Retrofit): RetroInterface {
        return retrofit.create(RetroInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}