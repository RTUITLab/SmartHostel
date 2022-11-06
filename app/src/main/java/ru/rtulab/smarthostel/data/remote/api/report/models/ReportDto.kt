package ru.rtulab.smarthostel.data.remote.api.report.models

import kotlinx.serialization.Serializable
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithoutDate
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectDto
import ru.rtulab.smarthostel.data.remote.api.profile.models.ProfileDto

@Serializable
data class ReportDto(
    val id:Int,
    val description:String,
    val isDone:Boolean,
    val pictures: List<String>,
    val objectId: Int,
    val residentId: Int
){
    fun toReport(obj:ObjectWithoutDate,resident:ProfileDto) = Report(
        id = id,
        description = description,
        isDone = isDone,
        pictures = pictures,
        objectFull = obj,
        resident = resident
    )

}