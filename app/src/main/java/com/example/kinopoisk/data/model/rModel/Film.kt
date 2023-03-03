package com.example.kinopoisk.data.model.rModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film")
data class Film(

    @PrimaryKey
    @ColumnInfo(name = "int_id")
    val filmId: Int,
    @ColumnInfo(name = "length")
    var filmLength: String? = "",
    @ColumnInfo(name = "name_eng")
    var nameEn: String? = "",
    @ColumnInfo(name = "name_rus")
    var nameRu: String? = "",
    @ColumnInfo(name = "poster_url")
    var posterUrl: String? = "",
    @ColumnInfo(name = "page")
    var page: Int = 1,

//    val countries: List<Country>,
//    val genres: List<Genre>,
//    val posterUrlPreview: String,
//    val rating: String,
//    val ratingChange: Any,
//    val ratingVoteCount: Int,
//    val year: String
)