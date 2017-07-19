package com.example.leandrom.myapplication.data.db

import com.example.leandrom.myapplication.domain.datasource.ForecastDataSource
import com.example.leandrom.myapplication.domain.model.Forecast
import com.example.leandrom.myapplication.domain.model.ForecastList
import com.example.leandrom.myapplication.extensions.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by madnotdead on 7/15/17.
 */

class ForecastDb (
    val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
    val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    override fun requestDayForecast(id: Long): Forecast? = forecastDbHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id)
                .parseOpt{ DayForecast(HashMap(it))}

        if(forecast != null) dataMapper.convertDayToDomain(forecast) else null

    }

    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.NAME} = ? " +
                "AND ${DayForecastTable.DATE} >= ?"

        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }


        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt{ CityForecast(HashMap(it), dailyForecast) }

        if(city != null) dataMapper.convertToDomain(city) else null
    }


    fun saveForecast(forecasts: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecasts)) {

            insert(CityForecastTable.NAME, *map.toVarargArray())

            dailyForecast.forEach {
                insert( DayForecastTable.NAME, *it.map.toVarargArray() )
            }
        }
    }
}