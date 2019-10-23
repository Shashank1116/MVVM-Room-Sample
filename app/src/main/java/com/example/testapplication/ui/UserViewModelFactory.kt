package com.example.testapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.testapplication.UserListViewModel
import com.example.testapplication.data.Repository


class UserViewModelFactory(private val repository: Repository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            return UserListViewModel(repository) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class");
    }

}