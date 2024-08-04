package com.example.moneyapp.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.R
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.theme.GrayG200

@Composable
fun MoreScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E6D6)) // light pinkish background
            .padding(16.dp)
    ) {
        CustomHeader(title = R.string.more) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(24.dp))
        MenuItem(icon = ImageVector.vectorResource(R.drawable.ic_website), text = "Transfer From Website", showDivider = true)
        MenuItem(icon = ImageVector.vectorResource(R.drawable.ic_favorite), text = "Favourites", showDivider = true)
        MenuItem(icon = ImageVector.vectorResource(R.drawable.ic_profile), text = "Profile", showDivider = true)
        MenuItem(icon = ImageVector.vectorResource(R.drawable.ic_help), text = "Help", showDivider = true)
        MenuItem(icon = ImageVector.vectorResource(id = R.drawable.ic_logout), text = "Logout", showDivider = false)
    }
}
@Composable
fun MenuItem(icon: ImageVector, text: String, showDivider: Boolean) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {}
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = GrayG200,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_right_arrow),
                contentDescription = "Arrow",
                tint = GrayG200,
                modifier = Modifier.size(24.dp)
            )
        }
        if (showDivider) {
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }
    }
}

@Preview
@Composable
private fun MoreScreenPreview() {
    val navController = rememberNavController()
    MoreScreen(navController)
}