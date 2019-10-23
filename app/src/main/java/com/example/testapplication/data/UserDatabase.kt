package com.example.testapplication.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.testapplication.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO
    companion object {

        // marking the instance as volatile to ensure atomic access to the variable
        @Volatile
        private var INSTANCE: UserDatabase? = null

            @Volatile private var instance: UserDatabase? = null
            private val LOCK = Any()

            fun getDatabase(context: Context)= instance ?: synchronized(LOCK){
                instance ?: buildDatabase(context).also { instance = it}
            }

            private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
                UserDatabase::class.java, "user_database.db")
                .build()
        }

    }