package com.example.kinopoisk.data.api

import com.example.kinopoisk.App
import com.example.kinopoisk.App.Companion.KINO_TOKEN
import com.example.kinopoisk.data.model.rModel.FilmModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    //    @Headers(
//        value = ["X-API-KEY: 24d61c28-5812-49d1-9138-7a2fa2833aa2",
//            "Content-Type: application/json"]
//    )
    @GET("top")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("type") type: String = "TOP_100_POPULAR_FILMS"
    ): Response<FilmModel>
}