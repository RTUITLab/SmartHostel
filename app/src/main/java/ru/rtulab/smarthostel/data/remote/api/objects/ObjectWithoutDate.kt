package ru.rtulab.smarthostel.data.remote.api.objects

import kotlinx.serialization.Serializable

@Serializable
data class ObjectWithoutDate(
    val name:String,
    val status:Int,
    val type:String,
    val room:String
)