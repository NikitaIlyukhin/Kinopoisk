package com.example.kinopoisk.data.api

import com.example.kinopoisk.App
import com.example.kinopoisk.data.model.restModel.FilmModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("movie")
    suspend fun getMovies(
        @Query("token") token: String = App.KINO_TOKEN
    ): Response<FilmModel>
}