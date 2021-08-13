package ru.solntsev.android.weatherforecast.model.network.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.solntsev.android.weatherforecast.internal.BASE_URL
import ru.solntsev.android.weatherforecast.model.network.WeatherApi
import java.util.concurrent.TimeUnit

object  WeatherService {
    private fun createOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(15, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    fun getClient(): WeatherApi {
        return Retrofit.Builder()
            .client(createOkHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}