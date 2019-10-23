package com.example.testapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.data.Repository
import com.example.testapplication.data.UserDataSource

class UserListViewModel(val repository: Repository): ViewModel(){

   var listObservable : LiveData<List<User>>?=null

    fun getUserList(){
        repository.getUserList(object :UserDataSource.GetUserListCallbacks{
            override fun onListLoaded(list: LiveData<List<User>>) {
                listObservable = list
            }

            override fun onError(e: String) {
            }

        })
    }


    fun addUsers(list: List<User>){
        repository.saveUserList(list)
    }

}