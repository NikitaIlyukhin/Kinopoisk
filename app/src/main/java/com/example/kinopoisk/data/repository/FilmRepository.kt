package com.example.kinopoisk.data.repository

import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.data.model.rModel.FilmModel
import retrofit2.Response

interface FilmRepository {
    fun getFilmById(id:Int):Film
    suspend fun getAllFilms(): Response<FilmModel>
}