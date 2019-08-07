package com.edt.myapplication.domain.datasource

import com.edt.myapplication.domain.model.Forecast
import com.edt.myapplication.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}
