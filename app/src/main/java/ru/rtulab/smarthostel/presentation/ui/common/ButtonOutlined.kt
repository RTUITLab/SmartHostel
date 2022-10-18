package ru.rtulab.smarthostel.presentation.ui.common


import androidx.compose.foundation.BorderStroke
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
fun ButtonOutlined(
    text:String ="Button",
    colorBorder:Color = MaterialTheme.colors.onPrimary,
    onClick:() -> Unit = {},

    ){
    Card(
        backgroundColor = Color.Transparent,
        modifier = Modifier.fillMaxWidth(),
        onClick =  onClick ,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp,colorBorder)
    )
    {
        Text(
            modifier = Modifier
                .padding(0.dp,12.dp),
            text = text,
            color = colorBorder,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
    }
}