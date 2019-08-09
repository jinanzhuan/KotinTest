package com.edt.myapplication.domain.commands

import com.edt.myapplication.domain.datasource.ForecastProvider
import com.edt.myapplication.domain.model.ForecastList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RequestForecastCommand(private val zipCode: Long, private val forecastProvider: ForecastProvider): Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }
    override suspend fun execute() = withContext(Dispatchers.IO) {
        forecastProvider.requestByZipCode(zipCode, DAYS)
    }

}