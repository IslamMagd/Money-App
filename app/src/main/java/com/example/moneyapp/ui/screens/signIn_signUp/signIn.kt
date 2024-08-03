package com.example.moneyapp.ui.screens.signIn_signUp

import android.content.Intent
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moneyapp.MainActivity
import com.example.moneyapp.R
import com.example.moneyapp.routes.Route.SIGNUP
import com.example.moneyapp.ui.theme.Dark_pink
import com.example.moneyapp.ui.theme.Dark_red_bg
import com.example.moneyapp.ui.theme.Light_pink
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField


@Composable
fun SignInScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = navController.context

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(

                    colors = listOf(
                        Color(Light_pink.value), // Start color
                        Color(Dark_pink.value)  // End color
                    )
                )
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(stringResource(id = R.string.Sign_in), fontSize = 24.sp)
                Spacer(modifier = Modifier.height(64.dp))
                Text(stringResource(id = R.string.speedo_transfer), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(64.dp))

            CustomTextField(
                text = stringResource(R.string.email),
                message = stringResource(R.string.enter_your_email_address),
                value = email,
                onValueChange = { email = it },
                imageRes = painterResource(id = R.drawable.ic_email),
                trailingIconOn = true
            )


            CustomTextField(text = stringResource(R.string.password),
                message = stringResource(R.string.enter_your_password),
                value = password,
                isPassord = true,
                onValueChange = { password = it }
            )
            Spacer(modifier = Modifier.height(24.dp))

            ClickedButton(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                textId = R.string.Sign_in,
                modifier = Modifier.padding(20.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(R.string.don_t_have_an_account), fontSize = 16.sp, color = Gray)
                Spacer(modifier = Modifier.width(4.dp))
                ClickableText(
                    text = AnnotatedString(stringResource(R.string.sign_up)),
                    onClick = { navController.navigate(SIGNUP) },
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color(Dark_red_bg.value),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = NavController(LocalContext.current))
}
