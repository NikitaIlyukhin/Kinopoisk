package com.example.kinopoisk.data.model.restModel

data class FilmModel(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)