package ru.rtulab.smarthostel.presentation.ui.authtorization

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.presentation.ui.authtorization.components.Title
import ru.rtulab.smarthostel.presentation.ui.common.ButtonFill
import ru.rtulab.smarthostel.ui.theme.White
import ru.rtulab.smarthostel.ui.theme.White50

@Preview
@Composable
fun Authtorization(){

    val selectedLogin = remember { mutableStateOf("") }
    var selectedPassword = remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title(
            modifier = Modifier
                .padding(top =72.dp)
        )

        OutlinedTextField(

            value = selectedLogin.value,
            onValueChange ={ selectedLogin.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            placeholder = {
                Text(
                    text = stringResource(R.string.login),
                    fontSize = 14.sp,
                    color = White50
                )},

            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                placeholderColor = White50,
                backgroundColor = Color.Transparent,
                textColor = White,
                cursorColor = White,
                focusedBorderColor = White,
                unfocusedBorderColor = White50
            ),
            singleLine = true,

        )
        OutlinedTextField(

            value = selectedLogin.value,
            onValueChange ={ selectedLogin.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            placeholder = {
                Text(
                    text = stringResource(R.string.password),
                    fontSize = 14.sp,
                    color = White50
                )},

            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                placeholderColor = White50,
                backgroundColor = Color.Transparent,
                textColor = White50,
                cursorColor = White50,
                focusedBorderColor = White50,
                unfocusedBorderColor = White50
            ),
            singleLine = true,

            )
        ButtonFill(
            modifier = Modifier
                .padding(top=24.dp),
            text = stringResource(R.string.Enter),
            colorFill = MaterialTheme.colors.primary,
            onClick = {
                //
            }
        )
        Text(
            text = stringResource(R.string.NothaveAccount),
            modifier = Modifier
                .padding(top=16.dp)
                .clickable {
                //
            },
            fontSize = 14.sp,
            color = MaterialTheme.colors.primary
        )
    }
}