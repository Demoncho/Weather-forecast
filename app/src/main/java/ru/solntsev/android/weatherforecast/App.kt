package ru.solntsev.android.weatherforecast

import android.app.Application
import ru.solntsev.android.weatherforecast.model.database.WeatherDatabase

class App : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        database = WeatherDatabase.invoke(this)
    }

    companion object {
        lateinit var instance: App
        lateinit var database: WeatherDatabase
    }
}