package com.example.moneyapp.data

import android.content.Context
import android.content.Intent
import com.example.moneyapp.MainActivity

fun saveCredentials(email: String, pass: String, cbState: Boolean, context: Context) {
    val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
    if (cbState) {
        editor.putString("email", email)
        editor.putString("password", pass)
    } else {
        editor.putString("email", "")
        editor.putString("password", "")
    }
    editor.apply()

}