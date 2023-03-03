package com.example.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieNetworkModule {

    private val BASE_URL = "https://howtodoandroid.com/"

    private val loginInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loginInterceptor)
            .build()
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createMovieApi(): MovieApi{
        val retrofit = getRetrofit()
        return retrofit.create(MovieApi::class.java)
    }
}