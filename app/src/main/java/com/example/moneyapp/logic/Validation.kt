package com.example.moneyapp.logic


fun isEmailValid(email: String): Boolean {
    val emailPattern = Regex("[a-zA-Z0–9._-]+@[a-z]+\\.+[a-z]+")
    return emailPattern.matches(email)
}

fun isPasswordValid(password: String): Boolean {
    val passwordPattern =
        Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{6,}\$")
    return passwordPattern.matches(password)
}