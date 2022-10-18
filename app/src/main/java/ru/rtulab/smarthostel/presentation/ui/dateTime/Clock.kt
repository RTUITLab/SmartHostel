package ru.rtulab.smarthostel.presentation.ui.dateTime

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rtulab.smarthostel.R

@Preview
@Composable
fun Clock(){
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row() {
                    Image(painter =  painterResource(R.drawable.up), contentDescription = "Up")
                }
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                ) {
                    BigTimeItem()
                }
                Row() {
                    Image(painter =  painterResource(R.drawable.down), contentDescription = "Up")
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = ":",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,

                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row() {
                    Image(painter =  painterResource(R.drawable.up), contentDescription = "Up")
                }
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                ) {
                    BigTimeItem()
                }
                Row() {
                    Image(painter =  painterResource(R.drawable.down), contentDescription = "Up")
                }
            }
        }
    }
}