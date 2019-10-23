package com.example.testapplication.data

import androidx.lifecycle.LiveData
import com.example.testapplication.User

interface UserDataSource{
    interface GetUserListCallbacks{
        fun onListLoaded(list: LiveData<List<User>>)
        fun onError(e:String)
    }

    fun getUserList(callbacks: GetUserListCallbacks)
    fun saveUserList(list:List<User>)
}