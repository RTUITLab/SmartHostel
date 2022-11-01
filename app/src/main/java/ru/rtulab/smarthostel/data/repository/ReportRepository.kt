package ru.rtulab.smarthostel.data.repository

import ru.rtulab.smarthostel.common.ResponseHandler
import ru.rtulab.smarthostel.data.remote.api.report.ReportApi
import ru.rtulab.smarthostel.data.remote.api.report.models.RequestCreateReport
import javax.inject.Inject

class ReportRepository @Inject constructor(
    private var reportApi: ReportApi,
    private val handler: ResponseHandler
) {
    suspend fun createReport(requestCreateReport: RequestCreateReport) = handler{
        reportApi.createReport(requestCreateReport)
    }
}