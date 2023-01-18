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

class UserRepository {
    companion object {
        val dB: DataBase = App.dataBase
        private var user: LiveData<User>? = MutableLiveData<User>()

        fun createUser(newUser: User) {
//            user.value = User("1","1",false)
            CoroutineScope(Dispatchers.Default).launch {
                dB.getDaoUser().insertUser(newUser)
            }
        }
        fun getUserByPhone(phone: String): LiveData<User> {
            user = dB.getDaoUser().getUserByPhone(phone)
            return user as LiveData<User>
        }
        fun forgotActiveUser(){
            CoroutineScope(Dispatchers.Default).launch {
                dB.getDaoUser().forgotActiveUser()
            }
        }

        suspend fun getFilms():Response<FilmModel>{
            return AppModule.api.getMovies(App.KINO_TOKEN)
        }
    }
}