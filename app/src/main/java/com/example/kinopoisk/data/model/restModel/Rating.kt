package com.example.kinopoisk.data.model.restModel

data class Rating(
    val _id: String,
    val await: Double,
    val filmCritics: Int,
    val imdb: Int,
    val kp: Double,
    val russianFilmCritics: Int
)