package com.example.moneyapp.ui.screens.main.mycard

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.ADD_CARD
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.TransactionDetailCard
import com.example.moneyapp.ui.commonUi.button.ClickedButton

@Composable
fun MyCardsScreen(navController: NavController, modifier: Modifier = Modifier) {

    var isClickable by remember { mutableStateOf(false) }


    val context = LocalContext.current
    val prefs = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
    val savedCardholderName = prefs.getString("cardholder_name","")!!
    val savedCardNumber = prefs.getString("card_number","")!!
    Log.d("trace", "$savedCardholderName and $savedCardNumber ")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    )
    {

        CustomHeader(title = R.string.my_accounts) {
            navController.popBackStack()
        }
        Column(
            modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Bottom
        ) {
            if (savedCardholderName.isNotBlank() && savedCardNumber.isNotBlank()){
                TransactionDetailCard(
                    label = "From",
                    name = savedCardholderName,
                    account = savedCardNumber,
                    icon = painterResource(id = R.drawable.ic_bank)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column ( modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp),
                verticalArrangement = Arrangement.Bottom)

            {
                ClickedButton(
                    onClick = { navController.navigate(ADD_CARD) },
                    textId = R.string.add_new_account,
                    modifier = modifier
                )
            }

        }

    }
}


