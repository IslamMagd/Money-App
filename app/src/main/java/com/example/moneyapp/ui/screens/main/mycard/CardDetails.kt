package com.example.moneyapp.ui.screens.main.mycard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.OTP
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField


@Composable
fun CardDetailsScreen(navController: NavController, modifier: Modifier = Modifier) {

    var cardholderName by remember { mutableStateOf("") }
    var cardNo by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var CVV by remember { mutableStateOf("") }

    Column (
        modifier = modifier.padding(16.dp)
            .fillMaxSize()
    ){

        CustomHeader(title = R.string.add_card) {
            navController.popBackStack()
        }

        CustomTextField(
            text = "Cardholder name",
            message = "Enter Cardholder name" ,
            value = cardholderName,
            onValueChange = { cardholderName = it },
            imageRes = painterResource(id = R.drawable.ic_profile),
            trailingIconOn = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        CustomTextField(
            text = "card No ",
            message = "Enter Card Number" ,
            value = cardNo,
            onValueChange = { cardNo = it },
            imageRes = painterResource(id = R.drawable.ic_profile),
            trailingIconOn = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            OutlinedTextField(
                value = expiryDate,
                onValueChange = { newValue ->
                    if (newValue.length <= 5 && newValue.all { it.isDigit() || it.isSpecialCharacter() }) {
                        expiryDate = newValue
                    }
                },
                label = { Text("MM/YY") },
                placeholder = { Text("MM/YY") },
                modifier = Modifier.weight(1f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                value = CVV,
                onValueChange = { newValue ->
                    if (newValue.length <= 3 && newValue.all { it.isDigit() }) {
                        CVV = newValue
                    }
                },
                label = { Text("CVV") },
                placeholder = { Text("CVV") },
                modifier = Modifier.weight(1f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                // visualTransformation = { VisualTransformation.None }
            )
        }

        Spacer(modifier = Modifier.padding(16.dp))


        ClickedButton(onClick = { navController.navigate(OTP) }, textId = R.string.get_started, modifier =modifier )

    }


}

fun Char.isSpecialCharacter(): Boolean {
    return !this.isLetterOrDigit() && !this.isWhitespace()
}
