package com.example.moneyapp.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.routes.Route.SIGNIN
import com.example.moneyapp.ui.theme.Dark_pink
import com.example.moneyapp.ui.theme.Light_pink
import com.example.moneyapp.ui.commonUi.button.ClickedButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController, modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()


    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(

                    colors = listOf(
                        Color(Light_pink.value), // Start color
                        Color(Dark_pink.value)  // End color
                    )
                )
            ),
    ) { page ->
        when (page) {

            0 -> Amont()
            1 -> Confirmation()
            2 -> Payment()

        }
    }
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End)
    {
        TextButton(onClick = {
            navController.navigate(SIGNIN)
        }
        ) {


            Text(
                text = "Skip", color = Color.Black, fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 60.dp, end = 16.dp)
            )

        }


    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        ClickedButton(
            onClick = {

            },
            textId = R.string.next,
            modifier = Modifier
                .padding(16.dp)

        )
    }

}

