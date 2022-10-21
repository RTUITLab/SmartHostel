package ru.rtulab.smarthostel.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ru.rtulab.smarthostel.presentation.navigation.LocalNavController

@Composable
fun SmartHostel(){

    val navController = LocalNavController.current
    Scaffold(
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