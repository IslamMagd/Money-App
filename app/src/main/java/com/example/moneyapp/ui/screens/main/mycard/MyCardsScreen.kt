package com.example.moneyapp.ui.screens.main.mycard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.ADD_CARD
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.button.ClickedButton

@Composable
fun MyCardsScreen(navController: NavController, modifier: Modifier = Modifier) {

    var isClickable by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top =32.dp,bottom = 40.dp)
    )
    {

        CustomHeader(title = R.string.my_accounts) {
            navController.popBackStack()
        }
Column(
    modifier = Modifier.padding(16.dp),verticalArrangement = Arrangement.Bottom) {
    ClickedButton(
        onClick = { navController.navigate(ADD_CARD) },
        textId =R.string.add_new_account ,
       modifier = modifier
    )
}

        }
    }
