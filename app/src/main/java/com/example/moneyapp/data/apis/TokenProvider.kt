package com.example.moneyapp.data.apis

class TokenProvider {
    private var token: String? = null

    fun setToken(token: String) {
        this.token = token
    }

    fun getToken(): String? {
        return token
    }
}