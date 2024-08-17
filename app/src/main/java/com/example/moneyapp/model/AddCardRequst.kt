package com.example.moneyapp.model

import com.google.gson.annotations.SerializedName


data class AddCardRequst(
    @SerializedName("accountName")
    val cardholderName: String,
    @SerializedName("accountNumber")
    val cardNumber: String,
    val expiryDate: String,
    val cvv: String,
    val isActive: Boolean,
    @SerializedName("accountCurrency")
    val cardCurrency: String,
    val balance: Double
)
