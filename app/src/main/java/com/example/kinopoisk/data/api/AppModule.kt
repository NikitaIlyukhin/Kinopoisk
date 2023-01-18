package com.example.kinopoisk.data.api

import com.example.kinopoisk.App
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    private val retrofit by lazy {
        retrofit2.Retrofit
            .Builder()
            .baseUrl(App.KINO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val  api:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}