package com.example.moneyapp.data

data class CountryDTO(
    val id: Int,
    val currency: String,
    val flag: String,
    val country: String,
    val currencySymbol: String,
    val rateToDollar: Double
)
