package com.example.leandrom.myapplication.domain.commands

import com.example.leandrom.myapplication.data.server.ForecastByZipCodeRequest
import com.example.leandrom.myapplication.domain.datasource.ForecastProvider
import com.example.leandrom.myapplication.domain.model.ForecastList

/**
 * Created by leandrom on 20-May-17.
 */
class RequestForecastCommand(
        val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList>{


    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }

}