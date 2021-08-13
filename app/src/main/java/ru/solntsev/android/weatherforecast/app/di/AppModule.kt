package ru.solntsev.android.weatherforecast.app.di

import dagger.Module
import dagger.Provides
import ru.solntsev.android.weatherforecast.model.network.WeatherApi
import ru.solntsev.android.weatherforecast.model.network.response.Hourly
import ru.solntsev.android.weatherforecast.model.network.response.WeatherResponce
import ru.solntsev.android.weatherforecast.model.network.service.WeatherService
import ru.solntsev.android.weatherforecast.model.repository.WeatherRepository
import ru.solntsev.android.weatherforecast.view.weather.hourly.WeatherHourlyAdapter
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApi(): WeatherApi = WeatherService.getClient()

    @Provides
    fun provideWeatherRepository() = WeatherRepository()


    @Provides
    fun provideHourlyData() = ArrayList<Hourly>()

    @Provides
    fun provideWeatherHourlyAdapter(data: ArrayList<Hourly>)
            : WeatherHourlyAdapter = WeatherHourlyAdapter(data)
}