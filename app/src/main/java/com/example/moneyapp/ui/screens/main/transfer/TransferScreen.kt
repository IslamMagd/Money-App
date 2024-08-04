package com.example.moneyapp.ui.screens.main.transfer

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.MainActivity
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.CONFIRMATION_ROUTE
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.StepProgressBar
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField

@Composable
fun TransferScreen(navController: NavController) {

    val recipientName = remember { mutableStateOf("") }
    val recipientAccountNumber = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF3E7))
            .padding(16.dp)
    ) {
        CustomHeader(title = R.string.transfer){
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(24.dp))
        StepProgressBar(
            isFirstStepActive = true,
            isSecondStepActive = false,
            isThirdStepActive = false,
            isFirstDeviderActive = true,
            isSecondDeviderActive = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "How much are you sending?", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            label = { Text("Enter amount you want to send") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Recipient Information", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = recipientName.value,
            onValueChange = { recipientName.value = it },
            label = { Text("Recipient Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = recipientAccountNumber.value,
            onValueChange = { recipientAccountNumber.value = it },
            label = { Text("Recipient Account Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
        ClickedButton(
            onClick = {
                navController.navigate(CONFIRMATION_ROUTE)
            },
            textId = R.string.Continue,
            modifier = Modifier.padding(20.dp)
        )
    }
}
@Composable
@Preview
fun TransferScreenPreview() {
    val navController = rememberNavController()
    TransferScreen(navController)
}