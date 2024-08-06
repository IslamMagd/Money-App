package com.example.moneyapp.data.apis

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val tokenProvider = TokenProvider()
    val authInterceptor = AuthInterceptor { tokenProvider.getToken() }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    private val retrofit = Retrofit
        .Builder()
        .client(okHttpClient)
        .baseUrl("http://18.156.119.108:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val serviceApi: ServiceApi by lazy {
        retrofit.create(ServiceApi::class.java)
    }
}