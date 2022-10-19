package ru.rtulab.smarthostel.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.presentation.ui.common.ObjectCardWithDate

@Composable
fun Home(){
    //val array = listOf<>()
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 16.dp),
            text = stringResource(R.string.LastBooking),
            fontSize = 22.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Bold
        )
        //LastBooking
        ObjectCardWithDate()



    }
}