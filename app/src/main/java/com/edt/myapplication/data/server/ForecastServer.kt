package com.edt.myapplication.data.server

import com.edt.myapplication.data.db.ForecastDb
import com.edt.myapplication.domain.datasource.ForecastDataSource
import com.edt.myapplication.domain.model.ForecastList

class ForecastServer (private val dataMapper: ServerDataMapper = ServerDataMapper(),
                      private val forecastDb: ForecastDb = ForecastDb()): ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()

}