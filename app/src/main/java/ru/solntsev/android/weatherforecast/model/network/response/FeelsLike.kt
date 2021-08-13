package ru.solntsev.android.weatherforecast.model.network.response

data class FeelsLike(
    val day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
)