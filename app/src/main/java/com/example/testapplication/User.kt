package com.example.testapplication

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(
    @NonNull
    @ColumnInfo(name = "name") val name:String, @NonNull @ColumnInfo(name="id") @PrimaryKey val id:Int, @ColumnInfo(name="avatar") val avatar:String)