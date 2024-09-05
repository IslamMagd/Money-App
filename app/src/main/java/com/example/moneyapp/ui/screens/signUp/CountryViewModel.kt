package com.example.moneyapp.ui.screens.signUp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneyapp.data.CountryDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val _countries = MutableStateFlow<List<CountryDTO>>(emptyList())
    val countries = _countries.asStateFlow()

    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()

    fun getCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = ""
                Log.d("TAG", "getAccounts: $response")
            } catch (e: Exception) {
                // Handle the error appropriately
                Log.d("TAG", " error getAccounts: $e")
            }
        }
    }
}