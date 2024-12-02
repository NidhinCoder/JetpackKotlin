package com.example.x100

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userDao: UserDao) : ViewModel() {
    // ... other code
    fun insertUser(user: User) = viewModelScope.launch {
        userDao.insertUser(user)
    }
}