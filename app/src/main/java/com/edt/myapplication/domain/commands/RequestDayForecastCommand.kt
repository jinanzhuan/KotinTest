package com.edt.myapplication.domain.commands

import com.edt.myapplication.domain.datasource.ForecastProvider
import com.edt.myapplication.domain.model.Forecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RequestDayForecastCommand(val id: Long,
                                private val forecastProvider: ForecastProvider = ForecastProvider()
): Command<Forecast> {
    override suspend fun execute() = withContext(Dispatchers.IO) {
        forecastProvider.requestForecast(id)
    }
}