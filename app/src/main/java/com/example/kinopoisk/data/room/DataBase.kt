package com.example.kinopoisk.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kinopoisk.data.model.entity.User

@Database(
    entities = [
        User::class,
    ], version = 3
)
abstract class DataBase : RoomDatabase() {
    abstract fun getDaoUser(): DaoUser

    companion object{
        fun getDataBase(context: Context):DataBase{
            return Room.databaseBuilder(context.applicationContext,DataBase::class.java,"kinopoisk.db").fallbackToDestructiveMigration().build()
        }
    }
}