package com.example.kinopoisk.data.api


import com.example.kinopoisk.data.model.rModel.FilmExtend
import com.example.kinopoisk.data.model.rModel.FilmModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("top")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("type") type: String = "TOP_100_POPULAR_FILMS"
    ): Response<FilmModel>

    @GET("{id}")
    suspend fun getFilm(
        @Path("id") id: Long
    ): Response<FilmExtend>
}