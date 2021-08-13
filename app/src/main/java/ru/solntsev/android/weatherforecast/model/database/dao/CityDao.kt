package ru.solntsev.android.weatherforecast.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ru.solntsev.android.weatherforecast.model.entity.City

@Dao
interface CityDao : BaseDao<City> {
    @Query("SELECT * FROM city ORDER BY name DESC")
    fun getCities(): LiveData<List<City>>

    @Query("SELECT * FROM city where selected=1 ORDER BY name DESC")
    fun getSelectedCities(): LiveData<List<City>>

    @Query("SELECT * FROM city WHERE id=(:id)")
    fun getCity(id: Int): LiveData<City?>
}