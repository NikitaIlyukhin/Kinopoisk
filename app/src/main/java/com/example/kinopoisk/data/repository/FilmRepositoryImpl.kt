package com.example.kinopoisk.data.repository

import com.example.kinopoisk.data.model.restModel.FilmModel

interface FilmRepositoryImpl {
    fun getFilmById(id:Int):FilmModel
    fun getAllFilms():List<FilmModel>
}