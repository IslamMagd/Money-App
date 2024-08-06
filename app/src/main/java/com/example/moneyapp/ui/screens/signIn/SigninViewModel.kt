package com.example.moneyapp.ui.screens.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneyapp.data.apis.RetrofitBuilder
import com.example.moneyapp.model.LoginRequst
import com.example.moneyapp.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SigninViewModel: ViewModel() {
    private var _login = MutableStateFlow<LoginResponse?>(null)
    val login = _login.asStateFlow()

    private var _hasError = MutableStateFlow<String>("")
    val hasError = _hasError.asStateFlow()

    private var token: String? = null

    fun loginUser(loginRequst: LoginRequst){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitBuilder.serviceApi.loginUser(loginRequst)
                _login.update { response }

                response.token?.let {
                    token = it
                }
                _hasError.update { "" }
            } catch (e: Exception){
                Log.d("trace","Error: ${e.message}")
                _hasError.update { e.message.toString() }
            }
        }
    }

    fun getToken(): String? {
        return token
    }
}