package ru.rtulab.smarthostel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.rtulab.smarthostel.presentation.SmartHostel
import ru.rtulab.smarthostel.presentation.navigation.LocalNavController
import ru.rtulab.smarthostel.presentation.ui.authtorization.Authtorization
import ru.rtulab.smarthostel.presentation.viewmodel.LocalActivity
import ru.rtulab.smarthostel.ui.theme.SmartHostelTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authState = authViewModel.authState.collectAsState().value

            SmartHostelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if(authState){
                        CompositionLocalProvider(
                            LocalNavController provides rememberNavController(),
                            LocalActivity provides this
                        ) {
                            SmartHostel()
                        }
                    }else{
                        Authtorization(authViewModel::onLoginEvent)
                    }


                }
            }
        }
    }
}

