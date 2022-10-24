package ru.rtulab.smarthostel.presentation.ui.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.rtulab.smarthostel.common.Resource
import ru.rtulab.smarthostel.common.emitInIO
import ru.rtulab.smarthostel.common.persistence.AuthStateStorage
import ru.rtulab.smarthostel.data.remote.api.booking.models.BookingDto
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithDate
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectWithoutDate
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectDto
import ru.rtulab.smarthostel.data.remote.api.objects.models.ObjectType
import ru.rtulab.smarthostel.data.repository.BookingRepository
import ru.rtulab.smarthostel.data.repository.ObjectRepository
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val bookingRepo: BookingRepository,
    private val authStateStorage: AuthStateStorage,
) : ViewModel() {
    private var _bookingsResourceFlow = MutableStateFlow<Resource<List<BookingDto>>>(Resource.Loading)
    val bookingsResourceFlow = _bookingsResourceFlow.asStateFlow().also {
        fetchAllBooking()
    }
    fun fetchAllBooking() = _bookingsResourceFlow.emitInIO(viewModelScope){
        bookingRepo.fetchAllBookings()
    }

    fun onRefresh() {
        fetchAllBooking()
    }
    private var cachedObjects = emptyList<ObjectWithDate>()

    private var _bookingsFlow = MutableStateFlow(cachedObjects)
    val bookingsFlow = _bookingsFlow.asStateFlow()

    fun onResourceSuccess(objs: List<BookingDto>,objdto:List<ObjectDto>,objType:List<ObjectType>) {
        cachedObjects = objs.map { it.toBooking(objdto.find{ obj -> obj.id == it.objectId}!!.run{toObject(objType.find { t ->t.id == typeId}!!)},) }
        _bookingsFlow.value = cachedObjects
    }
}