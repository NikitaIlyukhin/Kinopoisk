package com.example.kinopoisk.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kinopoisk.data.model.entity.User

@Dao
interface DaoUser {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User):Long

    @Query("SELECT * FROM user u WHERE u.phone=:phone")
    fun getUserByPhone(phone:String): LiveData<User>

    @Query("UPDATE user SET active_flg=0")
    fun forgotActiveUser()

    @Query("SELECT * FROM user u WHERE u.active_flg=1")
    fun getActiveUser(): LiveData<User>

}