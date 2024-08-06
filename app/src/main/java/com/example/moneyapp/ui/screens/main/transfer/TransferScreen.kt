package com.example.moneyapp.ui.screens.main.transfer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.CONFIRMATION_ROUTE
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.StepProgressBar
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField
import com.example.moneyapp.ui.theme.Black
import com.example.moneyapp.ui.theme.RedP300

@Composable
fun TransferScreen(navController: NavController) {

    val recipientName = remember { mutableStateOf("") }
    val recipientAccountNumber = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
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

        CustomTextField(
            text = "Amount",
            message = "Enter amount you want to send" ,
            value = amount.value,
            onValueChange = { amount.value = it  },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )



        Spacer(modifier = Modifier.height(16.dp))

        Row(
             verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recipient Information",
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                modifier = Modifier.weight(1f),
                color = Black.copy(0.6f)
            )
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {

            }

            ) {


                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = null,
                    tint = RedP300,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = "Favourite",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = RedP300,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward_red),
                    contentDescription = null,
                    tint = RedP300,
                    modifier = Modifier.size(14.dp)
                )

            }

        }
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            text = "Recipient Name",
            message = "Enter Recipient Name" ,
            value = recipientName.value,
            onValueChange = { recipientName.value = it   },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )



        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            text = "Recipient Account",
            message = "Enter Recipient Account Number" ,
            value =recipientAccountNumber.value,
            onValueChange = { recipientAccountNumber.value = it   },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
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