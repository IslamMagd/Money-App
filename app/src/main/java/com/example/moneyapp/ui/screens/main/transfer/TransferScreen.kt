package com.example.moneyapp.ui.screens.main.transfer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneyapp.R
import com.example.moneyapp.data.CountryDTO
import com.example.moneyapp.navigation.MainRoutes.CONFIRMATION_ROUTE
import com.example.moneyapp.ui.commonUi.CustomHeader
import com.example.moneyapp.ui.commonUi.StepProgressBar
import com.example.moneyapp.ui.commonUi.button.ClickedButton
import com.example.moneyapp.ui.commonUi.textFields.CustomTextField
import com.example.moneyapp.ui.screens.signUp.CountryViewModel
import com.example.moneyapp.ui.theme.Black
import com.example.moneyapp.ui.theme.RedP300


@Composable
fun TransferScreen(navController: NavController,CountryViewModel: CountryViewModel = viewModel()) {
    CountryViewModel.getCountries()
    val recipientName = remember { mutableStateOf("") }
    val recipientAccountNumber = remember { mutableStateOf("") }
    val rate by remember { mutableStateOf(1.0) }
    val receivedValue by remember { mutableStateOf("") }
    val countries by CountryViewModel.countries.collectAsState()
    var sentValue by remember { mutableStateOf("") }
    var selectedSentCountry by remember { mutableStateOf(
        CountryDTO(0,"USD","US","United States","$",1.0)
    ) }
    var selectedRecivedCountry by remember { mutableStateOf(
        CountryDTO(0,"USD","US","United States","$",1.0)
    ) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            CustomHeader(title = R.string.transfer) {
                navController.popBackStack()
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        item {
            StepProgressBar(
                isFirstStepActive = true,
                isSecondStepActive = false,
                isThirdStepActive = false,
                isFirstDeviderActive = true,
                isSecondDeviderActive = false
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text(
                text = "How much are you sending?",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            Text(
                text = "Choose Currency?",
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight(400)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
            ) {
                Column {
                    Text(
                        text = "1 ${selectedSentCountry.currency} = $rate ${selectedRecivedCountry.currency}",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp),
                        fontWeight = FontWeight(450)
                    )
                    Text(
                        text = "Rate guaranteed (2h)",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(8.dp),
                        fontWeight = FontWeight(500),
                        color = Black.copy(0.5f)
                    )
                    Text(
                        text = "You Send",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        fontWeight = FontWeight(400)
                    )
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CurrencyDropdown(
                            onResult = {
                                selectedSentCountry = it
                            },
                            countries = countries
                        )
                        OutlinedTextField(
                            value = sentValue,
                            onValueChange = {
                                sentValue = it
                            },
                            modifier = Modifier.padding(horizontal = 16.dp),
                            shape = RoundedCornerShape(8.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }

                    HorizontalDivider(modifier = Modifier.padding(16.dp))

                    Text(
                        text = "You Send",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        fontWeight = FontWeight(400)
                    )

                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CurrencyDropdown(
                            onResult = {
                                selectedRecivedCountry = it
                            },
                            countries = countries
                        )
                        OutlinedTextField(
                            value = receivedValue,
                            onValueChange = {},
                            modifier = Modifier.padding(16.dp),
                            shape = RoundedCornerShape(8.dp),
                            readOnly = true,
                        )
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Recipient Information",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.weight(1f),
                    color = Black.copy(0.6f)
                )
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = RedP300,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = "Favourite",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = RedP300,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_forward_red),
                        contentDescription = null,
                        tint = RedP300,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            CustomTextField(
                text = "Recipient Name",
                message = "Enter Recipient Name",
                value = recipientName.value,
                onValueChange = { recipientName.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            CustomTextField(
                text = "Recipient Account",
                message = "Enter Recipient Account Number",
                value = recipientAccountNumber.value,
                onValueChange = { recipientAccountNumber.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        item {
            ClickedButton(
                onClick = {
                    navController.navigate(CONFIRMATION_ROUTE)
                },
                textId = R.string.Continue,
                modifier = Modifier.padding(20.dp)
            )
        }
    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyDropdown(
    onResult: (CountryDTO) -> Unit = {}, countries: List<CountryDTO>,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember {
        mutableStateOf(
            CountryDTO(0, "USD", "\uD83C\uDDFA\uD83C\uDDF8", "United States", "$", 1.0)
        )
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        BasicTextField(readOnly = true,
            value = "${selectedCurrency.flag} ${selectedCurrency.currency}",
            onValueChange = {},

            modifier = Modifier.padding(16.dp),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${selectedCurrency.flag} ${selectedCurrency.currency}",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(end = 8.dp),
                        fontWeight = FontWeight.Bold,
                        color = RedP300

                    )
                    Icon(painter = painterResource(id = R.drawable.ic_down_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(32.dp)
                            .clickable { expanded = true })
                }
            })
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = false
        }) {

            countries.forEach { country ->
                DropdownMenuItem(text = {
                    Text(
                        "${country.flag} ${country.currency}",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold,
                        color = RedP300
                    )
                }, onClick = {
                    selectedCurrency = country
                    onResult(selectedCurrency)
                    expanded = false
                })
                HorizontalDivider(modifier = Modifier.padding(16.dp))
            }

        }

    }
}



@Composable
@Preview
fun TransferScreenPreview() {
    val navController = rememberNavController()
    TransferScreen(navController)
}