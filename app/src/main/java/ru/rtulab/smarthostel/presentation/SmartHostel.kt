package ru.rtulab.smarthostel.presentation

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.rtulab.smarthostel.presentation.navigation.AppScreen
import ru.rtulab.smarthostel.presentation.navigation.LocalNavController
import ru.rtulab.smarthostel.presentation.ui.common.BasicTopAppBar
import ru.rtulab.smarthostel.presentation.ui.common.bottomsheet.BottomSheetViewModel
import ru.rtulab.smarthostel.presentation.ui.common.burgermenu.BurgerMenuViewModel
import ru.rtulab.smarthostel.presentation.ui.common.topAppBar.AppBarViewModel
import ru.rtulab.smarthostel.presentation.ui.common.topAppBar.AppTabsViewModel
import ru.rtulab.smarthostel.presentation.viewmodel.singletonViewModel
import ru.rtulab.smarthostel.ui.theme.Accent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmartHostel(
    appBarViewModel: AppBarViewModel = singletonViewModel(),
    appTabsViewModel: AppTabsViewModel = singletonViewModel(),
    bottomSheetViewModel: BottomSheetViewModel = singletonViewModel(),
    burgerMenuViewModel: BurgerMenuViewModel = singletonViewModel()
){

    val currentScreen by appBarViewModel.currentScreen.collectAsState()

    val navController = LocalNavController.current

    LaunchedEffect(bottomSheetViewModel.bottomSheetState.currentValue) {
        if (bottomSheetViewModel.bottomSheetState.currentValue == ModalBottomSheetValue.Hidden)
            bottomSheetViewModel.hide(this)
    }
    LaunchedEffect(burgerMenuViewModel.bottomSheetState) {
        if (!burgerMenuViewModel.bottomSheetState)
            burgerMenuViewModel.bottomSheetState =!burgerMenuViewModel.bottomSheetState
    }

    ModalBottomSheetLayout(
        sheetState = ModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),//заменить
        sheetContent = {

        },
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
                when (currentScreen) {

                    else -> BasicTopAppBar(
                        text = stringResource(currentScreen.screenNameResource),
                        //  onBackAction = onBackAction
                    )
                }

            },
            content = {

            },
            bottomBar = {

            }
        )
    }
}