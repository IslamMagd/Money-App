package com.example.moneyapp.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.example.moneyapp.routes.Route.TRANSACTION_DETAILS
import com.example.moneyapp.ui.theme.RedP300
import com.example.moneyapp.ui.commonUi.CustomHeader

@Composable
fun TransactionsScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
        //.padding(16.dp)


    ) {
        CustomHeader(title = stringResource(R.string.transaction)) {
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

        TransactionList() {
            navController.navigate(TRANSACTION_DETAILS)
        }

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


@Composable
fun TransactionDetailsScreen(navController: NavController, modifier: Modifier = Modifier) {
    val amount = stringResource(R.string._1000_usd)
    val from = stringResource(R.string.asmaa_dosuky)
    val to = stringResource(R.string.jonathon_smith)
    val transferAmount = stringResource(R.string._48_4220_egp)
    val reference = stringResource(R.string._123456789876)
    val date = stringResource(R.string._20_jul_2024_7_50_pm)


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomHeader(title = stringResource(R.string.successful_transaction)) {
            navController.popBackStack()
        }
        // Status Icon
        Icon(
            painter = painterResource(id = R.drawable.ic_success), // Replace with your icon resource
            contentDescription = "Success Icon",
            tint = Color.Unspecified,
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = amount,
            fontWeight = FontWeight(500),
            fontSize = 28.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Transfer amount",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Text(
            text = "Send money",
            style = MaterialTheme.typography.bodyLarge,
            color = RedP300
        )
        Spacer(modifier = Modifier.height(16.dp))
        TransactionDetails(modifier = modifier)
        /*TransactionInfoSection(
            from = from,
            to = to,
            transferAmount = transferAmount,
            reference = reference,
            date = date
        )*/
    }
}


@Composable
fun TransactionDetails(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // For scrolling if content overflows
    ) {
        // From section
        TransactionDetailCard(
            label = "From",
            name = "Asmaa Dosuky",
            account = "Account xxxx7890",
            icon = painterResource(id = R.drawable.ic_bank)
        )

        // Divider with a check mark in the center


        // To section
        TransactionDetailCard(
            label = "To",
            name = "Jonathon Smith",
            account = "Account xxxx7890",
            icon = painterResource(id = R.drawable.ic_bank)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(vertical = 8.dp)
                .offset(y = (-140).dp)
        ) {
            //HorizontalDivider()
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Check",
                tint = Color.White,
                modifier = Modifier
                    .background(Color(0xFFb08645), shape = CircleShape)
                    .size(42.dp)
                    .padding(4.dp)
            )
        }

        //Spacer(modifier = Modifier.height(16.dp))

        TransactionDetailItem()

    }
}

@Composable
fun TransactionDetailCard(label: String, name: String, account: String, icon: Painter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color(0xFFDAC7CA))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.size(width = 50.dp, height = 50.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Icon(
                        painter = icon,
                        contentDescription = "Transaction Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    )

                }

            }


            Spacer(modifier = Modifier.width(24.dp))
            Column {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall.copy(color = RedP300),
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 8.dp)

                )
                Text(
                    text = account,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun TransactionDetailItem() {

    Card(
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(Color(0xFFDAC7CA))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Transfer amount",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "48.1202 EGP",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f)
                )
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Reference",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "123456789876",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Date",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "20 Jul 2024 7:50 PM",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun TransactionsScreenPreview() {
    TransactionsScreen(navController = NavController(LocalContext.current))
}