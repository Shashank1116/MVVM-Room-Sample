package com.example.testapplication

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @NonNull
    @ColumnInfo(name = "name") var name:String, @NonNull @ColumnInfo(name="id") @PrimaryKey var id:Int, @ColumnInfo(name="avatar") var avatar:String)