package com.example.moneyapp.ui.screens.main.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.moneyapp.ui.commonUi.CombineTwoCards
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.theme.RedP300
import com.example.moneyapp.ui.theme.RedP50


@Composable
fun TransactionDetailsScreen(navController: NavController) {
    val amount = stringResource(R.string._1000_usd)
    val from = stringResource(R.string.asmaa_dosuky)
    val to = stringResource(R.string.jonathon_smith)
    val transferAmount = stringResource(R.string._48_4220_egp)
    val reference = stringResource(R.string._123456789876)
    val date = stringResource(R.string._20_jul_2024_7_50_pm)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomHeader(title = R.string.successful_transaction) {
            /* todo*/
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
        TransactionDetails(modifier = Modifier)
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


    CombineTwoCards(modifier = modifier, IsTransferIcon = false)

    TransactionDetailItem()

}


@Composable
fun TransactionDetailItem() {

    Card(
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(RedP50),
        modifier = Modifier.padding(16.dp)
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
    TransactionDetailsScreen(navController = NavController(LocalContext.current))
}