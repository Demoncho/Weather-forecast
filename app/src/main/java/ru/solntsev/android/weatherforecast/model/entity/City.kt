package ru.solntsev.android.weatherforecast.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class City (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val state: String?,
    val country: String,
    val lon: Double,
    val lat: Double,
    val selected: Boolean
)