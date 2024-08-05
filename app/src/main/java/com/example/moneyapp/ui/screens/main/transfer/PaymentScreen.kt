package com.example.moneyapp.ui.screens.main.transfer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.R
import com.example.moneyapp.ui.commonUi.CombineTwoCards
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.StepProgressBar
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.button.CustomOutlinedButton


@Composable
fun PaymentScreen(
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
            isThirdStepActive = true,
            isFirstDeviderActive = true,
            isSecondDeviderActive = true
        )


        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
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

        CombineTwoCards(modifier = modifier, IsTransferIcon = false)


        ClickedButton(
            onClick = {

            },
            textId = R.string.back_to_home,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(16.dp))

        CustomOutlinedButton(textId = R.string.add_to_favorite ,onClick = { /*TODO*/ })

    }
}


@Composable
@Preview
fun PaymentScreenPreview() {
    val navController = rememberNavController()
    PaymentScreen(navController)
}