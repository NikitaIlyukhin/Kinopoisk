package com.example.kinopoisk.data.api

import com.example.kinopoisk.App
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    private val client = OkHttpClient.Builder().apply {
        addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.header("X-API-KEY", App.KINO_TOKEN)
            builder.header("Content-Type", "application/json")
            return@Interceptor chain.proceed(builder.build())
        })
    }.build()

    private val retrofit by lazy {
        retrofit2.Retrofit.Builder().baseUrl(App.KINO_BASE_URL).client(client).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }
    val api: ApiService by lazy { retrofit.create(ApiService::class.java) }

}