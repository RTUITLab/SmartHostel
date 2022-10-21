package ru.rtulab.smarthostel.presentation.ui.common.burgermenu

import androidx.compose.material.DrawerState
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.rtulab.smarthostel.presentation.navigation.AppTab

class BurgerMenuViewModel(

):ViewModel()
{
    var bottomSheetState = false//hide

    fun reverseState() {
        bottomSheetState  = !bottomSheetState
    }
}