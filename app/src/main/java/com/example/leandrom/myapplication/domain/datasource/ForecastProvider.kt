package com.example.leandrom.myapplication.domain.datasource

import com.example.leandrom.myapplication.data.db.ForecastDb
import com.example.leandrom.myapplication.data.server.ForecastServer
import com.example.leandrom.myapplication.domain.model.Forecast
import com.example.leandrom.myapplication.domain.model.ForecastList
import com.example.leandrom.myapplication.extensions.firstResult

/**
 * Created by madnotdead on 7/15/17.
 */
class ForecastProvider (val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int) : ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode,todayTimeSpan())
        if(res != null && res.size >= days ) res else null
    }

    fun requestForecast(id: Long) : Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T
            = sources.firstResult { f(it) }
}