package com.jlrinterview.x3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegistrationViewModel (private val userDao:UserDao):ViewModel(){

    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val message: String) : UiState()
        data class Error(val message: String) : UiState()
    }
//    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
//    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
//
//    fun registerUser(username: String, password: String, phoneNumber: String) {
//        _uiState.value = UiState.Loading
//        viewModelScope.launch {
//            try {
//                val user = User(username, password, phoneNumber)
//                userDao.insertUser(user)
//                _uiState.value = UiState.Success("Registered successfully!")
//            }
//            catch (e:Exception)
//            {
//                _uiState.value = UiState.Error("Registration failed: ${e.message}")
//            }
//        }
//
//    }

}