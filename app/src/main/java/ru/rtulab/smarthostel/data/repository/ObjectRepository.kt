package ru.rtulab.smarthostel.data.repository

import ru.rtulab.smarthostel.common.ResponseHandler
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectApi
import ru.rtulab.smarthostel.data.remote.api.objects.ObjectTypeApi
import javax.inject.Inject

class ObjectRepository @Inject constructor(
    private val objectApi: ObjectApi,
    private val objectTypeApi: ObjectTypeApi,

    private val handler: ResponseHandler
) {
    suspend fun fetchAllObjects() = handler {
        objectApi.getAll()
    }
    suspend fun fetchAllObjectTypes() = handler {
        objectTypeApi.getAll()
    }
}