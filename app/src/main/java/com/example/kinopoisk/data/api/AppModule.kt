package com.example.kinopoisk.data.api

import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    private val retrofit by lazy {
        retrofit2.Retrofit
            .Builder()
            .baseUrl("https://api.kinopoisk.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val  api:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}