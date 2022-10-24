package ru.rtulab.smarthostel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import ru.rtulab.smarthostel.common.persistence.AuthStateStorage
import ru.rtulab.smarthostel.data.repository.ProfileRepository
import ru.rtulab.smarthostel.presentation.ui.Profile.ProfileViewModel
import ru.rtulab.smarthostel.presentation.viewmodel.singletonViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authStateStorage: AuthStateStorage,
    private val profileRepository: ProfileRepository
) : ViewModel() {

    var _authState = MutableStateFlow(authStateStorage.user!=null)
    var authState = _authState.asStateFlow()

    fun onLoginEvent(user:String,password:String) {
        runBlocking {
            authStateStorage.updateUserId(user)
            authStateStorage.updateUserPassword(password)
            profileRepository.fetchMe(user).handle (
                onSuccess = {
                        _authState.value = true
                },
                onError = {

                }
            )


        }
    }

    fun enterLogoutFlow() {
        runBlocking {
            authStateStorage.resetUserPassword()
            authStateStorage.resetUserId()
            _authState.value = false
        }    }
}