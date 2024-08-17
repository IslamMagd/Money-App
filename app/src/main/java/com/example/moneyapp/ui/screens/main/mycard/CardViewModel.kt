package com.example.moneyapp.ui.screens.main.mycard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneyapp.data.apis.RetrofitBuilder
import com.example.moneyapp.model.AddCardRequst
import com.example.moneyapp.model.AddCardResponse
import com.example.moneyapp.model.SignUpResponse
import com.example.moneyapp.model.SignupRequst
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardViewModel: ViewModel() {
    private var _addCardResult = MutableStateFlow<AddCardResponse?>(null)
    val addCardResult = _addCardResult.asStateFlow()

    private var _hasError = MutableStateFlow<String>("")
    val hasError = _hasError.asStateFlow()

    fun addCard(addCardRequst: AddCardRequst, token: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _addCardResult.update {
                    RetrofitBuilder.serviceApi.addCard("Bearer $token", addCardRequst)
                }
                _hasError.update { "" }
            } catch (e: Exception){
                Log.d("trace","Error: ${e.message}")
                _hasError.update { e.message.toString() }
            }
        }
    }
}