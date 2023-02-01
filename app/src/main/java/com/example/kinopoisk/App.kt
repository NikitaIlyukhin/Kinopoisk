package com.example.kinopoisk

import android.app.Application
import android.content.Context
import com.example.kinopoisk.data.room.DataBase

class App : Application() {

    companion object {
        lateinit var ctx: Context
        lateinit var dataBase: DataBase
        val KINO_TOKEN = "24d61c28-5812-49d1-9138-7a2fa2833aa2"
        val KINO_BASE_URL = "https://kinopoiskapiunofficial.tech/api/v2.2/films/"
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        dataBase = DataBase.getDataBase(ctx)
    }
}