package ru.rtulab.smarthostel.presentation.ui.common.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.ui.theme.Accent
import ru.rtulab.smarthostel.ui.theme.White

@Composable
fun Drawer(
    backgroundColor:Color = Accent,
    contentColor:Color = White,
    content: @Composable () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center
    ) {
        // Header
        /*Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = R.drawable.logo.toString(),
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )*/
        // Space between
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )
        content()

    }
}