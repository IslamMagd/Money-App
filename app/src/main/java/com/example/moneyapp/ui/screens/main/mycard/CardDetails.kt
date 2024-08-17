package com.example.moneyapp.ui.screens.main.mycard

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moneyapp.MainActivity
import com.example.moneyapp.R
import com.example.moneyapp.model.AddCardRequst
import com.example.moneyapp.navigation.BottomBarRoutes
import com.example.moneyapp.navigation.MainRoutes.OTP
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField


@Composable
fun CardDetailsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: CardViewModel = viewModel()
) {
    val context = LocalContext.current

    var cardholderName by remember { mutableStateOf("") }
    var cardNo by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var CVV by remember { mutableStateOf("") }

    val addCardResult by viewModel.addCardResult.collectAsState()

    val hasError by viewModel.hasError.collectAsState()
    if(hasError.contains("409"))
        Toast.makeText(LocalContext.current, "This username/email already exists", Toast.LENGTH_LONG).show()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        CustomHeader(title = R.string.add_card) {
            navController.popBackStack()
        }

        CustomTextField(
            text = "Cardholder name",
            message = "Enter Cardholder name",
            value = cardholderName,
            onValueChange = { cardholderName = it },
            imageRes = painterResource(id = R.drawable.ic_profile),
            trailingIconOn = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        CustomTextField(
            text = "card No ",
            message = "Enter Card Number",
            value = cardNo,
            onValueChange = { cardNo = it },
            imageRes = painterResource(id = R.drawable.ic_profile),
            trailingIconOn = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

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
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
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

        val addCardRequst = AddCardRequst(
            cardholderName, cardNo, expiryDate, CVV, true, "EGP", 20000.0)

        ClickedButton(
            onClick = {
                Log.d("trace", "${getToken(context)}")
//                Log.d("trace", "$addCardRequst")

                viewModel.addCard(AddCardRequst(cardholderName, cardNo, expiryDate, CVV, true, "EGP", 20000.0),
                    getToken(context)
                )
            },
            textId = R.string.get_started, modifier = modifier
        )

        addCardResult?.let {response ->
            saveCardNameAndNumber(response.cardholderName, response.cardNumber, context)
            LaunchedEffect(response) {
                Log.d("trace","${response.cardholderName} and ${response.cardNumber}")
                navController.navigate(BottomBarRoutes.Cards.route)
            }
        }
    }
}

fun Char.isSpecialCharacter(): Boolean {
    return !this.isLetterOrDigit() && !this.isWhitespace()
}

fun getToken(context: Context): String{
    val prefs = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)
   val savedToken = prefs.getString("token","")!!
    return savedToken
}

fun saveCardNameAndNumber(cardholderName: String, cardNumber: String, context: Context){
    val editor = context.getSharedPreferences("user_data", Context.MODE_PRIVATE).edit()
    editor.putString("cardholder_name", cardholderName)
    editor.putString("card_number", cardNumber)
    editor.apply()
}
