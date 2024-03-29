package ru.rtulab.smarthostel.presentation.ui.common.topAppBar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.rtulab.smarthostel.presentation.navigation.AppTab
import javax.inject.Inject


@HiltViewModel
class AppTabsViewModel @Inject constructor(
    //authStateStorage: AuthStateStorage
) : ViewModel() {
    // private val userClaimsFlow = authStateStorage.userClaimsFlow

    private val _statePage = MutableStateFlow(1)
    val statePage = _statePage.asStateFlow()

    private val _appFourTabs = MutableStateFlow(AppTab.four)
    val appFourTabs = _appFourTabs.asStateFlow()

    private val _appTabs = MutableStateFlow(AppTab.all)
    val appTabs = _appTabs.asStateFlow()


    init {
        viewModelScope.launch {
            var from = 0
            val appTabsAccess = allAppTabsAccess()
            val appFourTabsAccess = fourAppTabsAccess()

            _appTabs.emit(AppTab.all.toList())
            _appFourTabs.emit(AppTab.four.toList())

        }
    }


    fun allAppTabsAccess(): List<AppTab> {
        return _appTabs.value.filter { it.accessible }
    }
    fun fourAppTabsAccess(): List<AppTab> {
        return _appFourTabs.value.filter { it.accessible }
    }
}
