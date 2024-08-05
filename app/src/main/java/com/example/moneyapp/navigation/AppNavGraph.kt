package com.example.moneyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moneyapp.navigation.MainRoutes.ADD_CARD
import com.example.moneyapp.navigation.MainRoutes.ADD_CARD_DETAILS
import com.example.moneyapp.navigation.MainRoutes.CONFIRMATION_ROUTE
import com.example.moneyapp.navigation.MainRoutes.INTERNET_ERROR
import com.example.moneyapp.navigation.MainRoutes.OTP
import com.example.moneyapp.navigation.MainRoutes.OTP_CONNECTED
import com.example.moneyapp.navigation.MainRoutes.PAYMENT_ROUTE
import com.example.moneyapp.navigation.MainRoutes.SERVER_ERROR
import com.example.moneyapp.navigation.MainRoutes.TRANSACTION_DETAILS
import com.example.moneyapp.ui.screens.errors.InternetError
import com.example.moneyapp.ui.screens.errors.ServerErrorScreen
import com.example.moneyapp.ui.screens.main.CardsScreen
import com.example.moneyapp.ui.screens.main.HomeScreen
import com.example.moneyapp.ui.screens.main.MoreScreen
import com.example.moneyapp.ui.screens.main.mycard.AddCardScreen
import com.example.moneyapp.ui.screens.main.mycard.CardDetailsScreen
import com.example.moneyapp.ui.screens.main.mycard.MyCardsScreen
import com.example.moneyapp.ui.screens.main.mycard.OTPConnectedScreen
import com.example.moneyapp.ui.screens.main.mycard.OTPEnteredScreen
import com.example.moneyapp.ui.screens.main.transactions.TransactionDetailsScreen
import com.example.moneyapp.ui.screens.main.transactions.TransactionsScreen
import com.example.moneyapp.ui.screens.main.transfer.ConfirmationScreen
import com.example.moneyapp.ui.screens.main.transfer.PaymentScreen
import com.example.moneyapp.ui.screens.main.transfer.TransferScreen


@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
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
            MyCardsScreen( navController)
        }
        composable(route = BottomBarRoutes.More.route) {
            MoreScreen(navController)
        }
        composable(route = INTERNET_ERROR) {
            InternetError(navController = navController)
        }
        composable(route = SERVER_ERROR) {
            ServerErrorScreen(navController = navController)
        }
        composable(route = CONFIRMATION_ROUTE) {
            ConfirmationScreen(navController = navController)
        }
        composable(route = PAYMENT_ROUTE) {
            PaymentScreen(navController = navController)
        }
        composable(route = TRANSACTION_DETAILS) {
            TransactionDetailsScreen(navController = navController)
        }
        composable(route = ADD_CARD) {
            AddCardScreen(navController = navController)
        }
        composable(route = ADD_CARD_DETAILS) {
            CardDetailsScreen(navController = navController)
        }

        composable(route = OTP) {
            OTPEnteredScreen(
                navController = navController
            )
        }
        composable(route = OTP_CONNECTED) {
            OTPConnectedScreen(
                navController = navController
            )
        }
    }
}