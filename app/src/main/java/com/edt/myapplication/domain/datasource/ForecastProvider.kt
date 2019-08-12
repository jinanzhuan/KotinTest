package com.edt.myapplication.domain.datasource

import com.edt.myapplication.data.db.ForecastDb
import com.edt.myapplication.data.server.ForecastServer
import com.edt.myapplication.domain.model.ForecastList
import com.edt.myapplication.extensions.firstResult

class ForecastProvider(private val sources: List<ForecastDataSource> = ForecastProvider.SOURCE) {
    companion object {
        const val DAY_IN_MILLIS =1000 * 60 * 60 * 24
        val SOURCE by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        var res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T: Any> requestToSources(f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }
}