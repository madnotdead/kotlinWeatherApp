package com.example.leandrom.myapplication.domain.datasource

import com.example.leandrom.myapplication.domain.model.Forecast
import com.example.leandrom.myapplication.domain.model.ForecastList

/**
 * Created by madnotdead on 7/15/17.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long) : ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}