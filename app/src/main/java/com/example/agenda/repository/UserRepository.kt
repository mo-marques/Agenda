package com.example.agenda.repository

import androidx.lifecycle.LiveData
import com.example.agenda.data.UserDao
import com.example.agenda.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}