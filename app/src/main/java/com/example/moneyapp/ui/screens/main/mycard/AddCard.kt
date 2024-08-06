package com.example.moneyapp.ui.screens.main.mycard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.ADD_CARD_DETAILS
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.screens.signUp.CountryList

@Composable
fun AddCardScreen(navController: NavController, modifier: Modifier = Modifier) {

    var isSheetOneOpen by rememberSaveable { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("") }

    Column (
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {

        CustomHeader(title = R.string.select_currency) {
            navController.popBackStack()
        }


        CountryList(currentCountry = selectedCountry, onCountrySelected = {
            isSheetOneOpen = !isSheetOneOpen
            selectedCountry = it
        })
        Spacer(modifier = Modifier.padding(16.dp))
        ClickedButton(
            onClick = { navController.navigate(ADD_CARD_DETAILS) },
            textId = R.string.get_started,
            modifier = modifier
        )

    }


}
