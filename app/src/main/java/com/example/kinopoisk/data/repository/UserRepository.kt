package com.example.kinopoisk.data.repository

import androidx.lifecycle.LiveData
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.data.model.rModel.FilmExtend
import com.example.kinopoisk.data.model.rModel.FilmModel
import retrofit2.Response

interface UserRepository {
    fun createUser(newUser: User)
    fun getUserByPhone(phone: String): LiveData<User>
    fun forgotActiveUser()
    fun getActiveUser(): LiveData<User>
    suspend fun getAllFilms(page:Int): Response<FilmModel>
    suspend fun getFilm(id:Long): Response<FilmExtend>
}