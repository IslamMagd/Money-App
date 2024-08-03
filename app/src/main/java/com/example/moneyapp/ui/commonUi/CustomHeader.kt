package com.example.moneyapp.ui.commonUi

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.moneyapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomHeader(title: String, onBackClick: () -> Unit) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = Color.Black,

                )
        },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Back button",
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White.copy(alpha = 0f)
        )

    )

}
