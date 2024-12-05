package com.jlrinterview.demoapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jlrinterview.demoapp.MainApplication
import com.jlrinterview.demoapp.data.User
import com.jlrinterview.demoapp.data.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class RegisterViewModel:ViewModel() {
    val userDao = MainApplication.demoDatabase.getUserDao()
    val usersList : LiveData<List<User>> =userDao.getAllUsers()

    fun addUser(name:String,pass:String,email:String,phoneNumber:String)
    {
        viewModelScope.launch (Dispatchers.IO){
            userDao.addUser(User(0,name,pass,email,phoneNumber))
        }

    }
}