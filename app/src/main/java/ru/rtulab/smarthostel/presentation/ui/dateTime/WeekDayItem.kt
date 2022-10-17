package ru.rtulab.smarthostel.presentation.ui.dateTime

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun WeekDayItem(
     weekDay:String = "Mn",
     date:String = "10"

){
    Card(
        shape =  RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp,MaterialTheme.colors.onBackground),
        backgroundColor = Color.Transparent,
        onClick = {
            //change active status
        }

    ) {
        Column(
            modifier = Modifier.padding(10.dp,4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(
                    text = weekDay,
                    fontSize = 11.sp,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Row() {
                Text(
                    text = date,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onSecondary
                )
            }
        }
    }
}