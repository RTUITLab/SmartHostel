package ru.rtulab.smarthostel.data.remote.api.booking

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.rtulab.smarthostel.data.remote.api.booking.models.BookingDto
import ru.rtulab.smarthostel.data.remote.api.booking.models.RequestBookingCreate
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithDate
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectDto

interface BookingApi {

    @GET("/reservations/")
    suspend fun getAll():List<BookingDto>

    @POST("/reservations/")
    suspend fun createBook(
        @Body booking:RequestBookingCreate
    ):Response<Unit>
}