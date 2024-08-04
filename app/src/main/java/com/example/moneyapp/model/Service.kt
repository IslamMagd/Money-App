package com.example.moneyapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Service(
    @StringRes val name: Int,
    @DrawableRes val icon: Int
)
