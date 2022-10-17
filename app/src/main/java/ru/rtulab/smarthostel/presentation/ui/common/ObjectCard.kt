package ru.rtulab.smarthostel.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ObjectCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)



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
                        text = "Name",
                        fontSize = 16.sp,

                        )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f, false),
                    horizontalArrangement = Arrangement.End,
                ) {
                    Text(

                        text = "Status",
                        fontSize = 14.sp
                    )
                }
            }
            Row() {
                Text(
                    text = "Type",
                    fontSize = 11.sp
                )
            }
            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(
                    text = "Owner",
                    fontSize = 14.sp
                )
            }
        }
    }
}