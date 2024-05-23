package com.example.a30daysoffitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FitnessDay(
    val dayNumber: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
