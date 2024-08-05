package com.example.moneyapp.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneyapp.R
import com.example.moneyapp.data.listDataSource.ServiceDataSource
import com.example.moneyapp.model.Service
import com.example.moneyapp.ui.theme.Dark_pink
import com.example.moneyapp.ui.theme.GrayG0
import com.example.moneyapp.ui.theme.GrayG10
import com.example.moneyapp.ui.theme.GrayG700
import com.example.moneyapp.ui.theme.Light_pink
import com.example.moneyapp.ui.theme.RedP300
import com.example.moneyapp.ui.theme.RedP50
import com.example.moneyapp.ui.theme.YelloS400

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(Light_pink.value), Color(Dark_pink.value)
                    )
                )
            )
    ) {
        TopSection()
        BalanceSection()
        ServicesSection()
        RecentTransactionsSection()
    }


}

@Composable
fun TopSection(modifier: Modifier = Modifier) {
    val user = "Ahmed Mohamed"
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 16.dp)
    ) {
        IconButton(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(RedP300.copy(alpha = 0.1f)),
            onClick = { /*TODO: navigate to profile screen*/ },
        ) {
            val names = user.split(" ")
            val intials = names.joinToString("") { it.first().toString() }

            Text(
                text = intials,
                fontSize = 20.sp,
                color = RedP300.copy(alpha = 0.6f),
                fontWeight = FontWeight(500)
            )


        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {


            Text(
                text = "Welcome Back,",
                fontSize = 18.sp,
                color = RedP300,
                fontWeight = FontWeight(500)
            )

            Text(
                text = user,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight(500)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_notifications),
            contentDescription = "bell icon",
            Modifier
                .size(40.dp)
                .clickable {/* to navigate to notification screen */ }
        )
    }
}

@Composable
fun BalanceSection(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = RedP300),
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(top = 16.dp)
    ) {
        Column(
            modifier = modifier
                .padding(12.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Current Balance",
                color = GrayG0,
                modifier = modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "$2,85,856.20",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = GrayG0,
                modifier = modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun ServicesSection(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = GrayG0),
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(top = 16.dp)
    ) {
        Column(
            modifier = modifier
                .padding(12.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Services",
                color = GrayG700,
                modifier = modifier
                    .padding(bottom = 16.dp)
            )
            ServiceList(services = ServiceDataSource().getServiceData())


        }

    }
}

@Composable
fun ServiceListItem(service: Service, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = GrayG10),
            modifier = modifier
                .size(68.dp),
            onClick = { /*TODO*/ }

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = service.icon),
                    contentDescription = stringResource(id = service.name),
                    tint = YelloS400,
                    modifier = modifier.size(40.dp),


                    )
            }

        }
        Text(
            text = stringResource(id = service.name),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun ServiceList(services: List<Service>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        services.forEach { service ->
            ServiceListItem(service = service)
        }
    }
}

@Composable
fun RecentTransactionsSection() {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recent transactions",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight(500),
            )
            Text(
                text = "View All",
                fontSize = 16.sp,
                color = Color.Black.copy(alpha = 0.5f),
                fontWeight = FontWeight(500),
                modifier = Modifier.clickable {
                    /**/
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn() {
            items(4) {
                TransactionItem()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}

@Composable
fun TransactionItem(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card(
                colors = CardDefaults.cardColors(containerColor = RedP50),
                modifier = modifier
                    .size(68.dp)

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_visa),
                        contentDescription = "visa icon",
                        modifier = modifier
                            .size(40.dp)
                            .fillMaxSize()
                    )
                }

            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Ahmed Mohamed", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "Visa . Master Card . 1234", fontSize = 14.sp, color = Color.Gray)
                Text(text = "Today 11:00 - Received", fontSize = 14.sp, color = Color.Gray)
            }
        }
        Text(
            text = "$1000",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF800020)
        )
    }
}


@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    HomeScreen()

}