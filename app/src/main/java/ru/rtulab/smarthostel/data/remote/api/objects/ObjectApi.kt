package ru.rtulab.smarthostel.data.remote.api.objects

import retrofit2.http.GET
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectDto

interface ObjectApi {
    @GET("/objects/")
    suspend fun getAll():List<ObjectDto>

}