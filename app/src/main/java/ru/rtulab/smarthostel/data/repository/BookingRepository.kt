package ru.rtulab.smarthostel.data.repository

import ru.rtulab.smarthostel.common.ResponseHandler
import ru.rtulab.smarthostel.data.remote.api.booking.BookingApi
import ru.rtulab.smarthostel.data.remote.api.profile.ProfileApi
import javax.inject.Inject

class BookingRepository @Inject constructor(
    private val bookingApi: BookingApi,
    private val handler: ResponseHandler
) {
    suspend fun fetchAllBookings() = handler {
        bookingApi.getAll()

    }
}
