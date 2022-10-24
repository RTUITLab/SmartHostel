package ru.rtulab.smarthostel.data.remote.api.booking

import retrofit2.http.GET
import ru.rtulab.smarthostel.data.remote.api.booking.models.BookingDto
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithDate
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectDto

interface BookingApi {

    @GET("/reservations/")
    suspend fun getAll():List<BookingDto>
}