package ru.rtulab.smarthostel.data.remote.api.objects

import retrofit2.http.GET
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectDto
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectType

interface ObjectTypeApi {
        @GET("/object_types/")
        suspend fun getAll():List<ObjectType>
}