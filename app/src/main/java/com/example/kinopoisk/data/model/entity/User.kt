package com.example.kinopoisk.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "phone")
    var phone: String,
    @ColumnInfo(name = "password")
    var password: String,
    @ColumnInfo(name = "active_flg")
    var activeFlg: Boolean,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}