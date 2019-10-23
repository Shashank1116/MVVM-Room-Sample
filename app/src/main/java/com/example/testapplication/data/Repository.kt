package com.example.testapplication.data

import androidx.lifecycle.LiveData
import com.example.testapplication.User

class Repository(private val localDataSource: LocalDataSource):UserDataSource{


    override fun getUserList(callbacks: UserDataSource.GetUserListCallbacks) {
        localDataSource.getUserList(callbacks)
    }


    override fun saveUserList(list: List<User>) {
        localDataSource.saveUserList(list)
    }

}