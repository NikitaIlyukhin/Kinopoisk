package com.example.kinopoisk

import android.app.Application
import android.content.Context
import com.example.kinopoisk.data.room.DataBase

class App : Application() {

    companion object {
        lateinit var ctx: Context
        lateinit var dataBase: DataBase
        val KINO_TOKEN = "ZQQ8GMN-TN54SGK-NB3MKEC-ZKB8V06"
        val KINO_BASE_URL = "https://api.kinopoisk.dev/"
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        dataBase = DataBase.getDataBase(ctx)
    }
}