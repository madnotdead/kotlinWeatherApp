package com.example.leandrom.myapplication.data.server

import com.example.leandrom.myapplication.data.db.ForecastDb
import com.example.leandrom.myapplication.domain.datasource.ForecastDataSource
import com.example.leandrom.myapplication.domain.model.ForecastList

/**
 * Created by madnotdead on 7/15/17.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(), val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {

        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode,result)

        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode,date)
    }

}