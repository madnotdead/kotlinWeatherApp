package com.example.leandrom.myapplication.data.server

import com.google.gson.Gson
import java.net.URL

/**
 * Created by leandrom on 20-May-17.
 */
class ForecastByZipCodeRequest(val zipCode: Long, val gson: Gson = Gson()){

    companion object {
        private val APP_ID = "977f4b84158d728894c84267018c98f8"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}