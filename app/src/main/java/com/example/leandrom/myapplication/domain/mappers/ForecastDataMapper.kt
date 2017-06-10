package com.example.leandrom.myapplication.domain.mappers

import com.example.leandrom.myapplication.data.ForecastResult
import com.example.leandrom.myapplication.data.Forecast
import com.example.leandrom.myapplication.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.leandrom.myapplication.domain.model.Forecast as ModelForecast

/**
 * Created by leandrom on 20-May-17.
 */
class ForecastDataMapper{
    fun convertFromDataModel(forecast: ForecastResult):ForecastList{
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):List<ModelForecast>{
        return list.mapIndexed{
            index, forecast ->
            val dt = java.util.Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(index.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast{
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())

        return df.format(date)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}