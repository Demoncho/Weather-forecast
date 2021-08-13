package ru.solntsev.android.weatherforecast.model.network.response

data class WeatherResponce(
    val current: Current,
    val daily: List<Daily>,
    val hourly: ArrayList<Hourly>,
    val lat: Double,
    val lon: Double,
)