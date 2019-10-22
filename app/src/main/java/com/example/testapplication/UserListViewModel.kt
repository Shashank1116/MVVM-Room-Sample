package com.example.testapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.data.Repository
import com.example.testapplication.data.UserDataSource

class UserListViewModel(val repository: Repository): ViewModel(){

   var listObservable = MutableLiveData<List<User>>()

    fun getUserList(){
        repository.getUserList(object :UserDataSource.GetUserListCallbacks{
            override fun onListLoaded(list: List<User>) {
                listObservable.value = list
            }

            override fun onError(e: String) {
            }

        })
    }


    fun addUsers(list: List<User>){
        repository.saveUserList(list)
    }
    fun observeList(): LiveData<List<User>> {
        return listObservable
    }

}