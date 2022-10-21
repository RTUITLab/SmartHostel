package ru.rtulab.smarthostel.presentation.navigation

import android.content.res.Resources
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import ru.rtulab.smarthostel.R
import ru.rtulab.smarthostel.presentation.ui.Profile.Profile
import ru.rtulab.smarthostel.presentation.ui.booking.Booking
import ru.rtulab.smarthostel.presentation.ui.home.Home
import ru.rtulab.smarthostel.presentation.ui.objects.Objects

@Composable
fun NavigationGraph(
    navController: NavHostController
){

val allScreens = AppScreen.getAll(LocalContext.current)

    NavHost(navController, startDestination = NavItem.Home.screen_route){
        composable(NavItem.Home.screen_route){
            Home()
        }
        composable(NavItem.Home.screen_route){
            Home()
        }
        composable(NavItem.Home.screen_route){
            Home()
        }
        composable(NavItem.Home.screen_route){
            Home()
        }
    }
}

private fun NavGraphBuilder.homeGraph(
    resources:Resources
){
   navigation(
       startDestination = AppTab.Home.startDestination,
       route = AppTab.Home.route
   ) {
           composable(AppScreen.Home.route){
               Home()
           }
       }

}
private fun NavGraphBuilder.ObjectsGraph(
    resources:Resources
){
    navigation(
        startDestination = AppTab.Objects.startDestination,
        route = AppTab.Objects.route
    ) {
        composable(AppScreen.Objects.route){
            Objects()
        }
        composable(
            route = AppScreen.Objects.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern =
                        "https://"+/*${resources.getString(R.string.HOST_URI)}*/"/objects/{objectId}"
                }
            )
        ) {
         //   ObjectDetails()
        }
    }

}
private fun NavGraphBuilder.BookingGraph(
    resources:Resources
){
    navigation(
        startDestination = AppTab.Booking.startDestination,
        route = AppTab.Booking.route
    ) {
        composable(AppScreen.Booking.route){
            Booking()
        }
        composable(
            route = AppScreen.Booking.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern =
                        "https://"+/*${resources.getString(R.string.HOST_URI)}*/"/booking/{bookingId}"
                }
            )
        ) {
            //   BookingDetails()
        }
    }

}
private fun NavGraphBuilder.ProfileGraph(
    resources:Resources
){
    navigation(
        startDestination = AppTab.Profile.startDestination,
        route = AppTab.Profile.route
    ) {
        composable(AppScreen.Profile.route){
            Profile()
        }

    }

}