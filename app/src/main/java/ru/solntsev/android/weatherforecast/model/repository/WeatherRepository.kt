package ru.solntsev.android.weatherforecast.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.solntsev.android.weatherforecast.app.di.DaggerAppComponent
import ru.solntsev.android.weatherforecast.model.network.WeatherApi
import ru.solntsev.android.weatherforecast.model.network.response.WeatherResponce
import javax.inject.Inject

class WeatherRepository {

    @Inject
    lateinit var weatherApiService: WeatherApi

    private val _data by lazy { MutableLiveData<WeatherResponce>() }
    val data: LiveData<WeatherResponce>
        get() = _data

    private val _isInProgress by lazy { MutableLiveData<Boolean>() }
    val isInProgress: LiveData<Boolean>
        get() = _isInProgress

    private val _isError by lazy { MutableLiveData<Boolean>() }
    val isError: LiveData<Boolean>
        get() = _isError

    init {
        DaggerAppComponent.create().inject(this)
    }
}