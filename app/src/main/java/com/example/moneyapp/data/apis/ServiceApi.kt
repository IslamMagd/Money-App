package com.example.moneyapp.data.apis

import com.example.moneyapp.model.AddCardRequst
import com.example.moneyapp.model.AddCardResponse
import com.example.moneyapp.model.LoginRequst
import com.example.moneyapp.model.LoginResponse
import com.example.moneyapp.model.SignUpResponse
import com.example.moneyapp.model.SignupRequst
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ServiceApi {

    @POST("/api/register")
    suspend fun registerUser(@Body signupRequst: SignupRequst): SignUpResponse

    @POST("/api/login")
    suspend fun loginUser(@Body loginRequst: LoginRequst): LoginResponse

    @POST("/api/create_account")
    suspend fun addCard(
        @Header("Authorization") token: String,
        @Body addCardRequst: AddCardRequst): AddCardResponse
}