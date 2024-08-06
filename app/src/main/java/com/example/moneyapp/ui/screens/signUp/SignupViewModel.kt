package com.example.moneyapp.ui.screens.signUp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneyapp.data.apis.RetrofitBuilder
import com.example.moneyapp.model.SignUpResponse
import com.example.moneyapp.model.SignupRequst
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel: ViewModel() {
    private var _signup = MutableStateFlow<SignUpResponse?>(null)
    val signup = _signup.asStateFlow()

    private var _hasError = MutableStateFlow<String>("")
    val hasError = _hasError.asStateFlow()

    fun signupUser(signupRequst: SignupRequst){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _signup.update {
                    RetrofitBuilder.serviceApi.registerUser(signupRequst)
                }
                _hasError.update { "" }
            } catch (e: Exception){
                Log.d("trace","Error: ${e.message}")
                _hasError.update { e.message.toString() }
            }
        }
    }

}