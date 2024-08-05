package com.example.moneyapp.ui.screens.main.transfer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.PAYMENT_ROUTE
import com.example.moneyapp.ui.commonUi.CombineTwoCards
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.StepProgressBar
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.button.CustomOutlinedButton


@Composable
fun ConfirmationScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CustomHeader(title = R.string.transfer) {

        }
        Spacer(modifier = Modifier.height(18.dp))
        StepProgressBar(
            isFirstStepActive = true,
            isSecondStepActive = true,
            isThirdStepActive = false,
            isFirstDeviderActive = true,
            isSecondDeviderActive = false
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "1000 USD",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Transfer amount",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        CombineTwoCards(modifier = modifier)

        Spacer(modifier = Modifier.height(16.dp))
        ClickedButton(
            onClick = {
                navController.navigate(PAYMENT_ROUTE)
            },
            textId = R.string.confirm,
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedButton(R.string.previous, onClick = {})


    }
}


@Composable
@Preview
fun ConfirmationScreenPreview() {
    val navController = rememberNavController()
    ConfirmationScreen(navController)
}