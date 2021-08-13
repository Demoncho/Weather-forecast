package ru.solntsev.android.weatherforecast.view.weather.hourly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.solntsev.android.weatherforecast.R
import ru.solntsev.android.weatherforecast.databinding.ItemWeatherHourlyBinding
import ru.solntsev.android.weatherforecast.model.network.response.Hourly

class WeatherHourlyAdapter(
    private val weatherHourly: ArrayList<Hourly>
) : RecyclerView.Adapter<WeatherHourlyAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemWeatherHourlyBinding: ItemWeatherHourlyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_weather_hourly,
            parent,
            false
        )

        return Holder(itemWeatherHourlyBinding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemWeatherHourlyBinding.data = weatherHourly[position]
    }

    override fun getItemCount(): Int = weatherHourly.size

    fun setUpData(data: List<Hourly>) {
        weatherHourly.clear()
        weatherHourly.addAll(data)
        notifyDataSetChanged()
    }

    class Holder(
        val itemWeatherHourlyBinding: ItemWeatherHourlyBinding
    ) : RecyclerView.ViewHolder(itemWeatherHourlyBinding.root) {

    }
}