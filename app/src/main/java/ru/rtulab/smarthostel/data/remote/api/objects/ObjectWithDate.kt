package ru.rtulab.smarthostel.data.remote.api.objects

import kotlinx.serialization.Serializable

@Serializable
data class ObjectWithDate(
    val name:String,
    val status:String,
    val type:String,
    val room:String,
    val startTime:String,
    val endTime:String,
)
