package com.example.testapplication.data

import com.example.testapplication.User

interface UserDataSource{
    interface GetUserListCallbacks{
        fun onListLoaded(list: List<User>)
        fun onError(e:String)
    }

    fun getUserList(callbacks: GetUserListCallbacks)
    fun saveUserList(list:List<User>)
}