package com.example.moneyapp.ui.screens.main.transfer

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.MainActivity
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.PAYMENT_ROUTE
import com.example.moneyapp.ui.commonUi.SingleCard
import com.example.moneyapp.ui.commonUi.StepProgressBar
import com.example.moneyapp.ui.commonUi.TransferOrSuccesIcon
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.button.NotClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField
import com.example.moneyapp.ui.theme.CheckBackground
import com.example.moneyapp.ui.theme.YelloS400


@Composable
fun PaymentScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF3E7))
            .padding(16.dp)
    ) {
        CustomHeader(title = R.string.transfer) {

        }
        Spacer(modifier = Modifier.height(18.dp))
        StepProgressBar(
            isFirstStepActive = true,
            isSecondStepActive = false,
            isThirdStepActive = false,
            isFirstDeviderActive = true,
            isSecondDeviderActive = false
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(CheckBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_check_large),
                contentDescription = "Center Icon",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.transfer_was_successful), fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy((-20).dp) // Adjust this value to control the overlap
        ) {
            SingleCard(name = "islam magdy", account = "752001", isFrom = true )
            TransferOrSuccesIcon(true)
            SingleCard(name = "islam ibrahim", account = "752001", isFrom = false )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ClickedButton(
            onClick = {

            },
            textId = R.string.back_to_home,
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(size = 10.dp),
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(text=stringResource(id = R.string.add_to_favorite))
        }





    }
}


@Composable
@Preview
fun PaymentScreenPreview() {
    val navController = rememberNavController()
    PaymentScreen(navController)
}