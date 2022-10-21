package ru.rtulab.smarthostel.presentation

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import ru.rtulab.smarthostel.presentation.navigation.LocalNavController
import ru.rtulab.smarthostel.ui.theme.Accent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmartHostel(){

    val navController = LocalNavController.current

    ModalBottomSheetLayout(
        sheetState = ModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),//заменить
        sheetContent = {},
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        sheetBackgroundColor = Accent,

    ) {
        Scaffold(
            modifier = Modifier
                .blur(50.dp),
            drawerContent = {
                            
            },
            topBar ={
                    when(){

                    }

            },
            content = {

            },
            bottomBar = {

            }
        )
    }
}