package com.example.moneyapp.ui.screens.main.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.navigation.MainRoutes.TRANSACTION_DETAILS
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.theme.Dark_pink
import com.example.moneyapp.ui.theme.Light_pink
import com.example.moneyapp.ui.theme.RedP300

@Composable
fun TransactionsScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top =32.dp )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(Light_pink.value), // Start color
                        Color(Dark_pink.value)  // End color
                    )
                )
            )
    ) {
        CustomHeader(title = R.string.transaction) {
            navController.popBackStack()
        }
        Text(
            text = stringResource(R.string.transactions),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = Color.Black,
            //fontSize = 20.sp,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TransactionList(modifier = modifier, onClick = {navController.navigate(TRANSACTION_DETAILS)})

    }
}


@Composable
fun TransactionList(modifier: Modifier = Modifier, onClick: () -> Unit) {

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        val list = listOf(TransactionItem(
            stringResource(R.string.Name_Ahmed),
            stringResource(R.string.master_card),
            stringResource(R.string._1000),
            stringResource(R.string.successful),
            painterResource(id = R.drawable.ic_visa),
            true,
            onClick = { onClick() }
        ), TransactionItem(
            stringResource(R.string.Name_Ahmed),
            stringResource(R.string.master_card),
            stringResource(R.string._1000),
            stringResource(R.string.failed),
            painterResource(id = R.drawable.ic_visa),
            false,
            onClick = { onClick() }
        ), TransactionItem(
            stringResource(R.string.Name_Ahmed),
            stringResource(R.string.master_card),
            stringResource(R.string._1000),
            stringResource(R.string.successful),
            painterResource(id = R.drawable.ic_visa),
            true,
            onClick = { onClick() }
        ), TransactionItem(
            stringResource(R.string.Name_Ahmed),
            stringResource(R.string.master_card),
            stringResource(R.string._1000),
            stringResource(R.string.successful),
            painterResource(id = R.drawable.ic_visa),
            true,
            onClick = { onClick() }
        ), TransactionItem(
            stringResource(R.string.Name_Ahmed),
            stringResource(R.string.master_card),
            stringResource(R.string._1000),
            stringResource(R.string.successful),
            painterResource(id = R.drawable.ic_visa),
            true,
            onClick = { onClick() }
        )
        )
    }


}


@Composable
fun TransactionItem(
    name: String,
    details: String,
    amount: String,
    status: String,
    iconRes: Painter,
    isSuccessfulTransaction: Boolean,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFDAC7CA))
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = iconRes,
                        contentDescription = stringResource(R.string.transaction_icon),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )
                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = name, fontWeight = FontWeight.Bold)
                Text(text = details, color = Color.Gray)

            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.End) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = stringResource(R.string.forward_arrow),
                    modifier = Modifier
                        .size(25.dp)
                        .padding(bottom = 10.dp)
                        .alpha(0.5f)
                        .clickable {}
                        .align(Alignment.End)
                )
                if (isSuccessfulTransaction) {
                    Card(
                        modifier = Modifier.wrapContentSize(),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Green.copy(alpha = 0.15f))
                    ) {
                        Text(
                            text = status,
                            color = Green,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                } else {
                    Card(
                        modifier = Modifier.wrapContentSize(),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Red.copy(alpha = 0.15f))
                    ) {
                        Text(
                            text = status,
                            color = Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
        Row {
            Text(
                text = amount,
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                color = RedP300,
                modifier = Modifier.padding(start = 80.dp, bottom = 8.dp)
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
private fun TransactionsScreenPreview() {
    TransactionsScreen(navController = NavController(LocalContext.current))
}