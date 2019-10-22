package com.example.testapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapplication.User

@Dao
public interface UserDAO{

    @Query("SELECT * from user_table")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user : User)

    @Query("DELETE FROM user_table")
    fun deleteAll()
}