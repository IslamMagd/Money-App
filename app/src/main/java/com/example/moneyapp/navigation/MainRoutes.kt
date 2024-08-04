package com.example.moneyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object MainRoutes {
    const val CONFIRMATION_ROUTE = "confirmation"
    const val PAYMENT_ROUTE = "payment"
    const val INTERNET_ERROR = "internet_error"
    const val SERVER_ERROR = "server_error"
}

