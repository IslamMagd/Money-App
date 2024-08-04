package com.example.moneyapp.ui.commonUi

import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.sp
import com.example.moneyapp.R
import com.example.moneyapp.ui.theme.GrayG40
import com.example.moneyapp.ui.theme.RedP50
import com.example.moneyapp.ui.theme.YelloS400

@Composable
fun CombineTwoCards(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-20).dp) // Adjust this value to control the overlap
    ) {
        SingleCard(name = "islam magdy", account = "752001", isFrom = true )
        TransferOrSuccesIcon(false)
        SingleCard(name = "islam ibrahim", account = "752001", isFrom = false )

    }
}

@Composable
fun SingleCard(name: String, account: String, isFrom: Boolean,modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = RedP50),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(16.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(GrayG40),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_bank2),
                    contentDescription = "cnotification icon"
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = if (isFrom) "From" else "To", color = Color(0xFFD32F2F), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = account)
            }
        }

    }
}

@Composable
fun TransferOrSuccesIcon(isTransferIcon: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(YelloS400),
        contentAlignment = Alignment.Center
    ) {
        val iconResId = if (isTransferIcon) R.drawable.ic_transfer_money else R.drawable.ic_check
        Icon(
            imageVector = ImageVector.vectorResource(id = iconResId),
            contentDescription = "Center Icon",
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
@Preview
fun TransferCardsPreview() {
    CombineTwoCards()
}