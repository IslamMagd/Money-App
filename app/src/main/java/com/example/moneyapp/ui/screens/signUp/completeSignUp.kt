package com.example.moneyapp.ui.screens.signUp

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moneyapp.R
import com.example.moneyapp.model.SignupRequst
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField
import com.example.moneyapp.ui.theme.Dark_pink
import com.example.moneyapp.ui.theme.Light_pink
import com.example.moneyapp.ui.theme.RedP300
import java.text.SimpleDateFormat
import java.util.Calendar

@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompleteSignUpScreen(
    navController: NavController,
    name: String,
    email: String,
    password: String,
    viewModel: SignupViewModel = viewModel(),
    modifier: Modifier = Modifier) {

//    Log.d("trace","$name$email$password")

    val sheetStateOne = rememberModalBottomSheetState()
    var isSheetOneOpen by rememberSaveable { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("") }
    val openDialog = remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState()
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val context = LocalContext.current

    val signup by viewModel.signup.collectAsState()

    val hasError by viewModel.hasError.collectAsState()
    if(hasError.contains("409"))
        Toast.makeText(LocalContext.current, "This username/email already exists", Toast.LENGTH_LONG).show()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(
                brush = Brush.verticalGradient(

                    colors = listOf(
                        Color(Light_pink.value), // Start color
                        Color(Dark_pink.value)  // End color
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        Text(
            text = stringResource(id = R.string.speedo_transfer),
            fontSize = 24.sp,
            modifier = modifier
                .padding(40.dp)
                .padding(top = 120.dp),
            fontWeight = FontWeight(500)
        )
        Text(
            text = stringResource(R.string.welcome_to_banque_misr),
            fontSize = 24.sp,
            modifier = modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
            fontWeight = FontWeight(500)
        )
        Text(
            text = stringResource(R.string.lets_complete_your_profile),
            fontSize = 18.sp,
            modifier = modifier.padding(20.dp),
            fontWeight = FontWeight(350)
        )
        CustomTextField(
            text = stringResource(R.string.country),
            message = stringResource(R.string.select_your_country),
            value = selectedCountry,
            imageRes = painterResource(id = R.drawable.ic_down_arrow),
            trailingIconOn = true,
            onValueChange = { },
            onClick = {

                isSheetOneOpen = !isSheetOneOpen

            },
            isReadOnly = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        CustomTextField(
            text = stringResource(R.string.date_of_birth),
            message = stringResource(R.string.dd_mm_yyyy),
            value = selectedDate,
            imageRes = painterResource(id = R.drawable.ic_date),
            trailingIconOn = true,
            onValueChange = { },
            onClick = {
                openDialog.value = true
            },
            isReadOnly = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

            )

        if (isSheetOneOpen) {
            ModalBottomSheet(
                onDismissRequest = { isSheetOneOpen = !isSheetOneOpen },
                sheetState = sheetStateOne,

                ) {
                CountryList(currentCountry = selectedCountry, onCountrySelected = {
                    isSheetOneOpen = !isSheetOneOpen
                    selectedCountry = it
                })
            }
        }
        if (openDialog.value) {
            DatePickerDialog(onDismissRequest = { openDialog.value = false }, confirmButton = {
                Text(
                    text = stringResource(R.string.confirm),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            openDialog.value = false
                            val calendar = Calendar.getInstance()
                            calendar.timeInMillis = datePickerState.selectedDateMillis!!
                            val dateFormatter = SimpleDateFormat("yyyy-MM-dd")
                            selectedDate = dateFormatter.format(calendar.time)

                        },
                    color = RedP300,

                    )
            }) {
                DatePicker(state = datePickerState)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))


        ClickedButton(onClick = {
//            Log.d("trace", "$signupRequst"  )
            viewModel.signupUser(
                SignupRequst(
                    username = name,
                    password = password,
                    birthdate = selectedDate,
                    email = email,
                    country = selectedCountry
                )
            )
//            val intent = Intent(context, MainActivity::class.java)
//            context.startActivity(intent)
        }, textId = R.string.Continue, modifier = Modifier.padding(16.dp))
    }

}


@Composable

fun CountryList(
    currentCountry: String = "", onCountrySelected: (String) -> Unit = {}
) {
    val selectedCountry = remember { mutableStateOf("") }
    val countries = listOf(
        Pair("Egypt", "🇪🇬"),
        Pair("Mexico", "🇲🇽"),
        Pair("Argentina", "🇦🇷"),
        Pair("South Korea", "🇰🇷"),
        Pair("Saudi Arabia", "🇸🇦"),
        Pair("South Africa", "🇿🇦"),

        )

    LazyColumn(
        modifier = Modifier.heightIn(max = 400.dp)
    ) {
        items(countries) { (country, flag) ->

            Card(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 16.dp)
                    .clickable {
                        selectedCountry.value = country
                        onCountrySelected(country)

                    },
                colors = if (currentCountry == country) CardDefaults.cardColors(RedP300.copy(alpha = 0.2f)) else CardDefaults.cardColors(
                    Color.White
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp, horizontal = 16.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Text(

                            text = flag, fontSize = 24.sp, modifier = Modifier.padding(end = 16.dp)
                        )
                        Text(
                            text = country, fontWeight = FontWeight.Medium
                        )
                    }
                    if (currentCountry == country) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = RedP300,
                            modifier = Modifier.padding(start = 8.dp)

                        )
                    }
                }
            }
        }
    }
}
