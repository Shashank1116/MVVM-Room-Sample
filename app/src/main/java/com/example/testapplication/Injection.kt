package com.example.testapplication

import android.app.Application
import com.example.testapplication.data.LocalDataSource
import com.example.testapplication.data.Repository
import com.example.testapplication.data.UserDatabase

object Injection{
    fun provideRepository(application: Application):Repository{
        val userDatabase = UserDatabase.getDatabase(application)
        val localDataSource = LocalDataSource(userDatabase!!.userDao())
        return  Repository(localDataSource)
    }
}