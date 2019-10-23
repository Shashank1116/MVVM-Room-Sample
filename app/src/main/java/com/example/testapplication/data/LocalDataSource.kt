package com.example.testapplication.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.testapplication.User

class LocalDataSource(private val userDAO: UserDAO): UserDataSource{
    var list: LiveData<List<User>>?=null


    override fun getUserList(callbacks: UserDataSource.GetUserListCallbacks) {
        callbacks.onListLoaded(userDAO.getUsers())
    }



    override fun saveUserList(list: List<User>) {
        for(item in list){
            insertAsyncTask(userDAO).execute(item)
        }

    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: UserDAO) :
        AsyncTask<User, Void, String>() {
            override fun doInBackground(vararg params: User?): String {
            mAsyncTaskDao.insert(params[0]!!)
            return ""
        }

    }

}