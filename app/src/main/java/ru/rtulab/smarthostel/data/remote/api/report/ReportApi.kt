package ru.rtulab.smarthostel.data.remote.api.report

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.rtulab.smarthostel.data.remote.api.report.models.RequestCreateReport

interface ReportApi {

    @POST("/reports/")
    suspend fun createReport(
        @Body report: RequestCreateReport
    ): Response<Unit>
}