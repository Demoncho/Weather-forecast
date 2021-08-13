package ru.solntsev.android.weatherforecast.model.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.solntsev.android.weatherforecast.model.network.response.WeatherResponce

interface WeatherApi {
    @GET("/api.openweathermap.org/data/2.5/onecall")
    fun getTrending(
        @Query("lat") apiKey: String,
        @Query("lon") limit: String,
        @Query("appid") appid: String,
        @Query("exclude") exclude: String,
        @Query("lang") lang: String
    ): Call<WeatherResponce>
}