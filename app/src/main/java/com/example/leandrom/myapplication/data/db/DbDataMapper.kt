package com.example.leandrom.myapplication.data.db

import com.example.leandrom.myapplication.domain.model.Forecast
import com.example.leandrom.myapplication.domain.model.ForecastList

/**
 * Created by madnotdead on 7/15/17.
 */
class DbDataMapper {

    //Fron domain
    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id,city,country,daily)
    }

    fun convertDayFromDomain(cityId: Long, forecast: Forecast ) =  with(forecast) {
        DayForecast(date, description, high,low, iconUrl, cityId)
    }

    //To domain
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val dailyForecast = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id,city,country,dailyForecast)
    }

    fun convertDayToDomain(dayForecast: DayForecast ) = with(dayForecast) {
        Forecast(_id, date, description, high, low, iconUrl)
    }
}