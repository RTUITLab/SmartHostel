package ru.rtulab.smarthostel.presentation.navigation

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.provider.CalendarContract
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.core.os.bundleOf
import kotlinx.parcelize.Parcelize
import ru.rtulab.smarthostel.R

sealed class AppTab(
    val route: String,
    val startDestination: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector,
    var accessible: Boolean = true
) {
    object Home: AppTab("events_tab", AppScreen.Home.route, R.string.home, Icons.Default.Home)
    object Objects: AppTab("projects_tab", AppScreen.Objects.route, R.string.objects, Icons.Default.Face)
    object Booking: AppTab("devices_tab", AppScreen.Booking.route, R.string.booking, Icons.Default.ThumbUp,)
    object Profile: AppTab("profile_tab", AppScreen.Profile.route, R.string.profile, Icons.Default.AccountCircle)

    fun saveState() = bundleOf(SCREEN_KEY to route)

    fun asScreen() = when (this) {
        Home -> AppScreen.Home
        Objects -> AppScreen.Objects
        Booking -> AppScreen.Booking
        Profile -> AppScreen.Profile
    }
    companion object {
        const val SCREEN_KEY = "SCREEN_KEY"

        val all
            get() = listOf(
                Home,
                Objects,
                Booking,
                Profile,
            )
    }
}

@Parcelize
open class AppScreen(
    @StringRes val screenNameResource: Int,
    val route: String,
    val navLink: String = route.substringBefore("/{")
) : Parcelable {
    // Employee-related
    object Home: AppScreen(R.string.home, "home")
    object Objects: AppScreen(R.string.objects, "objects")
    object Booking: AppScreen(R.string.booking, "booking")
    object Profile: AppScreen(R.string.profile, "profile")
    @Parcelize
    class ObjectDetails(val title: String): AppScreen(R.string.object_details, "objects/{objectId}") { // Has back button
        companion object {
            const val route = "objects/{objectId}"
            val navLink: String = route.substringBefore("/{")
        }
    }
    @Parcelize
    class BookingDetails(val title: String): AppScreen(R.string.booking_details, "booking/{bookingId}") { // Has back button
        companion object {
            const val route = "booking/{bookingId}"
            val navLink: String = route.substringBefore("/{")
        }
    }
    object BookingNew: AppScreen(R.string.booking_new, "booking/new") // Has back button


    companion object {
        fun getAll(context: Context) = listOf(
            Home,
            Objects,
            Booking,
            Profile,
            ObjectDetails,
            BookingDetails,
            BookingNew
        )
    }
}