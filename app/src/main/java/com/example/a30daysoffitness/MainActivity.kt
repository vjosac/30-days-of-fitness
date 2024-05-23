package com.example.a30daysoffitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysoffitness.model.FitnessDay
import com.example.a30daysoffitness.model.FitnessDaysRepository.fitnessDays
import com.example.a30daysoffitness.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                ThirtyDaysOfFitnessScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
fun ThirtyDaysOfFitnessScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(fitnessDays) {
                DayItem(
                    fitnessDay = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun DayItem(
    fitnessDay: FitnessDay,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.secondaryContainer
    )


    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Column {
                Text(
                    text = stringResource(R.string.day, fitnessDay.dayNumber),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = stringResource(fitnessDay.title),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(start = 8.dp)
                )
                ExerciseImage(
                    image = fitnessDay.image,
                    onClick = {
                        expanded = !expanded
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                if (expanded) {
                    DayDescriptionExpanded(
                        dayDesc = fitnessDay.description,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ExerciseImage(
    @DrawableRes image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable(onClick = onClick)
    )
}

@Composable
fun DayDescriptionExpanded(
    @StringRes dayDesc: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(dayDesc),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .padding(top = 16.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    AppTheme {
        ThirtyDaysOfFitnessScreen()
    }
}