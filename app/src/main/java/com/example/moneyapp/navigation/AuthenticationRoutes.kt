package com.example.moneyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moneyapp.navigation.Route.HOME
import com.example.moneyapp.navigation.Route.SIGNIN
import com.example.moneyapp.navigation.Route.SIGNUP
import com.example.moneyapp.navigation.Route.SIGNUP2
import com.example.moneyapp.navigation.Route.SPLASH
import com.example.moneyapp.ui.screens.SplashScreen
import com.example.moneyapp.ui.screens.onboarding.OnBoardingScreen
import com.example.moneyapp.ui.screens.signIn.SignInScreen
import com.example.moneyapp.ui.screens.signUp.CompleteSignUpScreen
import com.example.moneyapp.ui.screens.signUp.SignUpScreen


object Route {
    const val HOME = "onboarding"
    const val SIGNUP = "signup"
    const val SIGNUP2 = "signup2"
    const val SIGNIN = "signin"
    const val SPLASH = "splash"
    const val HOME_SCREEN = "home_screen"



}


@Composable
fun StartNavHost() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SPLASH) {

        composable(route = SPLASH) { SplashScreen(navController = navController) }
        composable(route = HOME) { OnBoardingScreen(navController = navController) }
        composable(route = SIGNUP) { SignUpScreen(navController = navController) }
        composable(
            route = "$SIGNUP2/{name}/{email}/{password}",
            arguments = listOf(
                navArgument("name"){ type = NavType.StringType},
                navArgument("email"){ type = NavType.StringType},
                navArgument("password"){ type = NavType.StringType}
            )
        ) {
            val name = it.arguments?.getString("name")!!
            val email = it.arguments?.getString("email")!!
            val password = it.arguments?.getString("password")!!
            CompleteSignUpScreen(navController = navController, name = name, email = email, password = password )
        }
        composable(route = SIGNIN) { SignInScreen(navController = navController) }

    }
}


