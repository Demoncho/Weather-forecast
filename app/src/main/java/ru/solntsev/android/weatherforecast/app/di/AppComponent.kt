package ru.solntsev.android.weatherforecast.app.di

import dagger.Component
import ru.solntsev.android.weatherforecast.MainActivity
import ru.solntsev.android.weatherforecast.model.repository.WeatherRepository
import ru.solntsev.android.weatherforecast.view.weather.hourly.WeatherHourlyViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(weatherRepository: WeatherRepository)

    fun inject(viewModel: WeatherHourlyViewModel)

    fun inject(mainActivity: MainActivity)
}