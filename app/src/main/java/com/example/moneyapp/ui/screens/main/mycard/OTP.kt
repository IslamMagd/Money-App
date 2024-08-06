package com.example.moneyapp.ui.screens.main.mycard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.OTP_CONNECTED
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.theme.RedP300

@Composable
fun OTPEnteredScreen(navController: NavController, modifier: Modifier = Modifier) {
    // State to hold the OTP input values
    var otpValues by remember { mutableStateOf(listOf("", "", "", "", "", "")) }
    // Create focus requesters for each OTP field
    val focusRequesters = List(6) { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        CustomHeader(title = R.string.bank_card_otp) {
            navController.popBackStack()
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Enter the digits verification code\nsent to Email@gmail.com",
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                otpValues.forEachIndexed { index, value ->
                    OutlinedTextField(
                        value = value,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                // Update the state with the new value for the current index
                                otpValues = otpValues.toMutableList().apply {
                                    this[index] = newValue
                                }

                                // Move focus to the next field
                                if (newValue.isNotEmpty() && index < focusRequesters.size - 1) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            }
                        },
                        modifier = Modifier
                            .width(48.dp)
                            .height(56.dp)
                            .focusRequester(focusRequesters[index]),
                        textStyle = androidx.compose.ui.text.TextStyle(textAlign = TextAlign.Center),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                if (index < focusRequesters.size - 1) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            }
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row {


                Text(text = buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.Black.copy(alpha = 0.5f))) {
                        append("Don't receive OTP? ")
                    }

                },
                    modifier = Modifier.align(Alignment.CenterVertically),fontSize = 16.sp)
                TextButton(onClick = {}) {
                    Text(text = buildAnnotatedString {
                        withStyle(SpanStyle(color = RedP300)) {
                            append("Resend OTP")
                        }
                    },fontSize = 16.sp)

                }
            }
            Spacer(modifier = Modifier.height(200.dp))

            // Check if all fields are filled
            val isButtonEnabled = otpValues.all { it.isNotEmpty() }

            Button(
                onClick = {
                    navController.navigate(OTP_CONNECTED)
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(RedP300),
                enabled = isButtonEnabled
            ) {
                Text(text = "Sign on", Modifier.padding(12.dp), color = Color.White, fontSize = 18.sp)
            }

        }

    }
}