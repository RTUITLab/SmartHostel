package ru.rtulab.smarthostel.data.remote.api.profile.models

import androidx.compose.ui.semantics.Role
import kotlinx.serialization.Serializable

@Serializable
data class ProfileDto(
    val id:Integer,
    val fio:String,
    val birthdate:String,
    val studentId:String,
    val room:Integer,
    val role: Integer

){
    fun toProfile() =
        Profile(
            lastName = fio.split(" ")[0],
            firstName = fio.split(" ")[1],
            room = "$room",
            role = "$role",
            imageLink = "",
            login = studentId
        )
}