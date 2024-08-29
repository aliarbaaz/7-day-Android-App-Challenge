package com.android.engineer.mealmate.data.auth_db

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(database: MealUserDatabase) : ViewModel() {
    private val userRepository = UserRepository(database.userDao())

    fun signupUser(user: User, onSignupSuccess: () -> Unit, onSignupError: () -> Unit) {
        viewModelScope.launch {
            try {
                val result = userRepository.insertUser(user)
                if(result > 0){
                    onSignupSuccess()
                } else {
                    onSignupError()
                }
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Signup error: ${e.message}", e)
                onSignupError()
            }
        }
    }

    fun loginUser(username: String, password: String, onLoginSuccess: () -> Unit, onLoginError: () -> Unit) {
        viewModelScope.launch {
            try {
                val user = userRepository.getUser(username, password)
                if (user != null) {
                    onLoginSuccess()
                } else {
                    onLoginError()
                }
            } catch (e: Exception) {
                Log.e("AuthViewModel", "Login error: ${e.message}", e)
                onLoginError()
            }
        }
    }
}
