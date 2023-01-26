package com.example.kinopoisk.data.repository

import androidx.lifecycle.LiveData
import com.example.kinopoisk.data.model.entity.User

interface UserRepositoryImpl {
    fun createUser(newUser: User)
    fun getUserByPhone(phone: String): LiveData<User>
    fun forgotActiveUser()
    fun getActiveUser(): LiveData<User>
}