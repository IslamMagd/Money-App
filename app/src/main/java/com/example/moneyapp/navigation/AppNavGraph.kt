package com.example.moneyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moneyapp.navigation.MainRoutes.CONFIRMATION_ROUTE
import com.example.moneyapp.navigation.MainRoutes.INTERNET_ERROR
import com.example.moneyapp.navigation.MainRoutes.PAYMENT_ROUTE
import com.example.moneyapp.navigation.MainRoutes.SERVER_ERROR
import com.example.moneyapp.ui.screens.errors.InternetError
import com.example.moneyapp.ui.screens.errors.ServerErrorScreen
import com.example.moneyapp.ui.screens.main.MoreScreen
import com.example.moneyapp.ui.screens.main.CardsScreen
import com.example.moneyapp.ui.screens.main.HomeScreen
import com.example.moneyapp.ui.screens.main.TransactionsScreen
import com.example.moneyapp.ui.screens.main.transfer.ConfirmationScreen
import com.example.moneyapp.ui.screens.main.transfer.PaymentScreen
import com.example.moneyapp.ui.screens.main.transfer.TransferScreen


@Composable
fun BottomNavGraph(navController: NavHostController,modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomBarRoutes.Home.route,
        modifier = modifier
    ) {
        composable(route = BottomBarRoutes.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarRoutes.Transfer.route) {
            TransferScreen(navController)
        }
        composable(route = BottomBarRoutes.Transactions.route) {
            TransactionsScreen(navController)
        }
        composable(route = BottomBarRoutes.Cards.route) {
            CardsScreen()
        }
        composable(route = BottomBarRoutes.More.route) {
            MoreScreen(navController)
        }
        composable(route = INTERNET_ERROR) {
            InternetError(navController = navController)
        }
        composable(route = SERVER_ERROR) {
            ServerErrorScreen(navController = navController )
        }
        composable(route = CONFIRMATION_ROUTE) {
            ConfirmationScreen(navController = navController)
        }
        composable(route = PAYMENT_ROUTE) {
            PaymentScreen(navController = navController )
        }
    }
}