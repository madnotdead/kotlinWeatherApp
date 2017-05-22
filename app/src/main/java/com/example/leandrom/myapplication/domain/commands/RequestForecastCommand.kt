package com.example.leandrom.myapplication.domain.commands

import com.example.leandrom.myapplication.data.ForecastRequest
import com.example.leandrom.myapplication.domain.mappers.ForecastDataMapper
import com.example.leandrom.myapplication.domain.model.ForecastList

/**
 * Created by leandrom on 20-May-17.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}