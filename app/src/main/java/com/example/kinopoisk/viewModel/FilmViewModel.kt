package com.example.kinopoisk.viewModel

import com.example.kinopoisk.data.model.restModel.FilmModel
import com.example.kinopoisk.data.repository.FilmRepositoryImpl

class FilmViewModel(private val repository: FilmRepositoryImpl) {
    lateinit var films: List<FilmModel>

    fun setFilms() {
        films = emptyList()
    }
}