package com.example.a30daysoffitness.model

import androidx.compose.ui.res.stringResource
import com.example.a30daysoffitness.R

object FitnessDaysRepository {
    val fitnessDays = listOf(
        FitnessDay(
            dayNumber = 1,
            title = R.string.day_one_title,
            image = R.drawable.day_one,
            description = R.string.day_one_desc
        ),
        FitnessDay(
            dayNumber = 2,
            title = R.string.day_two_title,
            image = R.drawable.day_two,
            description = R.string.day_two_desc
        ),
        FitnessDay(
            dayNumber = 3,
            title = R.string.day_three_title,
            image = R.drawable.day_three,
            description = R.string.day_three_desc
        ),
        FitnessDay(
            dayNumber = 4,
            title = R.string.day_four_title,
            image = R.drawable.day_four,
            description = R.string.day_four_desc
        ),
        FitnessDay(
            dayNumber = 5,
            title = R.string.day_five_title,
            image = R.drawable.day_five,
            description = R.string.day_five_desc
        ),
        FitnessDay(
            dayNumber = 6,
            title = R.string.day_six_title,
            image = R.drawable.day_six,
            description = R.string.day_six_desc
        ),
    )
}