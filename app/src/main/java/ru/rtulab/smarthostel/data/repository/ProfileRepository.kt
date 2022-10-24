package ru.rtulab.smarthostel.data.repository

import android.util.Log
import ru.rtulab.smarthostel.common.ResponseHandler
import ru.rtulab.smarthostel.data.remote.api.profile.ProfileApi
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileApi: ProfileApi,
    private val handler: ResponseHandler
) {

    suspend fun fetchMe(studentId:String) = handler {
        profileApi.getMe(studentId)

    }
}