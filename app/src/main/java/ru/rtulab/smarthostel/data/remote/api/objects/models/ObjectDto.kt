package ru.rtulab.smarthostel.data.remote.api.objects.models

import kotlinx.serialization.Serializable
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithoutDate

@Serializable
data class ObjectDto(
    val id:Int,
    val name:String,
    val description:String,
    val cloudId:String,
    val available:Boolean,
    val typeId:Int,
    val statusId:Int,
    val roomId:Int,
){
    fun toObject(objType: ObjectType) = ObjectWithoutDate(
        name =name,
        type = objType.name,
        status = statusId,
        room = "$roomId"

    )
}
