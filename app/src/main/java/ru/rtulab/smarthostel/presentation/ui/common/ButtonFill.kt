package ru.rtulab.smarthostel.presentation.ui.common

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ButtonFill(
    text:String ="Button",
    colorFill:Color = MaterialTheme.colors.primary,
    onClick:() -> Unit = {},

    ){

    Card(
        backgroundColor = colorFill,
        modifier = Modifier.fillMaxWidth(),
        onClick =  onClick ,
        shape = RoundedCornerShape(8.dp)
    )
    {

       Text(
           modifier = Modifier
               .padding(0.dp,12.dp),
           text = text,
           color = Color.Transparent,
           fontSize = 14.sp,
           lineHeight = 20.sp
       )
    }
}