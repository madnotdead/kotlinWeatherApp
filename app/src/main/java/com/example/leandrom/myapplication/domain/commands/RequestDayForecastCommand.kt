package com.example.leandrom.myapplication.domain.commands

import com.example.leandrom.myapplication.domain.datasource.ForecastProvider
import com.example.leandrom.myapplication.domain.model.Forecast

/**
 * Created by madnotdead on 7/17/17.
 */
class RequestDayForecastCommand (
        val id:Long,
        val forecastProvider: ForecastProvider = ForecastProvider()):
        Command<Forecast> {
    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}