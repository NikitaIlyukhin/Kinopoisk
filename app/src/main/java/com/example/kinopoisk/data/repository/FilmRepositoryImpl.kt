package com.example.kinopoisk.data.repository

import com.example.kinopoisk.data.api.AppModule
import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.data.model.rModel.FilmModel
import retrofit2.Response

class FilmRepositoryImpl:FilmRepository {
    override fun getFilmById(id: Int): Film {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFilms(): Response<FilmModel> {
        return AppModule.api.getMovies(1)
    }

}