package ru.rtulab.smarthostel.data.repository

import ru.rtulab.smarthostel.common.ResponseHandler
import ru.rtulab.smarthostel.data.remote.api.booking.BookingApi
import ru.rtulab.smarthostel.data.remote.api.booking.models.BookingDto
import ru.rtulab.smarthostel.data.remote.api.booking.models.RequestBookingCreate
import ru.rtulab.smarthostel.data.remote.api.profile.ProfileApi
import javax.inject.Inject

class BookingRepository @Inject constructor(
    private val bookingApi: BookingApi,
    private val handler: ResponseHandler
) {
    suspend fun fetchAllBookings() = handler {
        bookingApi.getAll()

    }
    suspend fun fetchBookingDetails(bookingId:String) = handler {
        bookingApi.getOne(bookingId)

    }

    suspend fun createBook(booking:RequestBookingCreate) = handler {
        bookingApi.createBook(booking)

    }

    suspend fun cancel(bookingId: String) {
        bookingApi.cancel(bookingId)
    }
}
