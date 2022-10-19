package ru.rtulab.smarthostel.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rtulab.smarthostel.ui.theme.White50

@Preview
@Composable
fun ObjectCardWithDate(
    name:String="Name",
    status:String ="Status",
    type:String = "Type",
    owner:String = "Owner",
    startTime:String = "Date Time",
    endTime:String = "Date Time",
    statusColor:Color = MaterialTheme.colors.onSecondary
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary



    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f, false)
                ) {
                    Text(
                        text = name,
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.onSecondary

                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f, false),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Text(

                        text = status,
                        fontSize = 14.sp,
                        color = statusColor
                    )
                }
            }
            Row() {
                Text(
                    text = type,
                    fontSize = 11.sp,
                    color = White50
                )
            }
            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(
                    text = owner,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onSecondary

                )
            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp)

            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f, false),
                ) {
                    Row() {
                        Text(
                            text = "Start",
                            fontSize = 11.sp
                        )
                    }
                    Row() {
                        Text(
                            text = startTime,
                            fontSize = 14.sp
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f, false),
                ) {
                    Row() {
                        Text(
                            text = "End",
                            fontSize = 11.sp
                        )
                    }
                    Row() {
                        Text(
                            text = endTime,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }

    }
}