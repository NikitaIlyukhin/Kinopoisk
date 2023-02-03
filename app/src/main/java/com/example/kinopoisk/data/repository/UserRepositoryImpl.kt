package com.example.kinopoisk.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kinopoisk.App
import com.example.kinopoisk.data.api.AppModule
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.data.model.rModel.FilmModel
import com.example.kinopoisk.data.room.DataBase
import kotlinx.coroutines.*
import retrofit2.Response

class UserRepositoryImpl : UserRepository {
    val dB: DataBase = App.dataBase
//    private var user: LiveData<User> = MutableLiveData<User>()

    override fun createUser(newUser: User) {
        CoroutineScope(Dispatchers.Default).launch {
            dB.getDaoUser().insertUser(newUser)
        }
    }

    override fun getUserByPhone(phone: String): LiveData<User> {
        return dB.getDaoUser().getUserByPhone(phone)
    }

    override fun forgotActiveUser() {
        CoroutineScope(Dispatchers.Default).launch {
            dB.getDaoUser().forgotActiveUser()
        }
    }

    override fun getActiveUser(): LiveData<User> {
        return dB.getDaoUser().getActiveUser()
    }
    override suspend fun getAllFilms(page:Int): Response<FilmModel> {
        return AppModule.api.getMovies(page)
    }
}