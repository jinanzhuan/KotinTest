package com.edt.myapplication.domain.datasource

import com.edt.myapplication.data.db.ForecastDb
import com.edt.myapplication.data.server.ForecastServer

class ForecastProvider(private val sources: List<ForecastDataSource>) {
    companion object {
        const val day_in_millis =1000 * 60 * 60 * 24
        val SOURCE by lazy { listOf(ForecastDb(), ForecastServer()) }
    }
}