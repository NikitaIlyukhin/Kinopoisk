package com.example.kinopoisk.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kinopoisk.App
import com.example.kinopoisk.data.api.AppModule
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.data.model.restModel.FilmModel
import com.example.kinopoisk.data.room.DataBase
import kotlinx.coroutines.*
import retrofit2.Response

class UserRepository : UserRepositoryImpl {
    val dB: DataBase = App.dataBase
    private var user: LiveData<User> = MutableLiveData<User>()

    override fun createUser(newUser: User) {
        CoroutineScope(Dispatchers.Default).launch {
            dB.getDaoUser().insertUser(newUser)
        }
    }

    override fun getUserByPhone(phone: String): LiveData<User> {
        user = dB.getDaoUser().getUserByPhone(phone)
        return user as LiveData<User>
    }

    override fun forgotActiveUser() {
        CoroutineScope(Dispatchers.Default).launch {
            dB.getDaoUser().forgotActiveUser()
        }
    }

    override fun getActiveUser(): LiveData<User> {
        user = dB.getDaoUser().getActiveUser()
        return user as LiveData<User>
    }
}