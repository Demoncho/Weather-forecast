package ru.solntsev.android.weatherforecast.view.weather.hourly

import androidx.lifecycle.ViewModel
import ru.solntsev.android.weatherforecast.app.di.DaggerAppComponent
import ru.solntsev.android.weatherforecast.model.repository.WeatherRepository
import javax.inject.Inject

class WeatherHourlyViewModel : ViewModel() {

    @Inject
    lateinit var repository: WeatherRepository

    //private val compositeDisposable by lazy { CompositeDisposable() }

    init {
        DaggerAppComponent.create().inject(this)
        //compositeDisposable.add(repository.fetchDataFromDatabase())
    }

    override fun onCleared() {
        super.onCleared()
        //compositeDisposable.clear()
    }
}