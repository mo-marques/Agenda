package com.example.agenda.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.agenda.data.UserDataBase
import com.example.agenda.repository.UserRepository
import com.example.agenda.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application){

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

}