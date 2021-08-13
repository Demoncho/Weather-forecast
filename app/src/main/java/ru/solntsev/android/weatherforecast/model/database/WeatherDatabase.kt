package ru.solntsev.android.weatherforecast.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.solntsev.android.weatherforecast.internal.DATABASE_NAME
import ru.solntsev.android.weatherforecast.model.database.dao.CityDao
import ru.solntsev.android.weatherforecast.model.entity.City

@Database(entities = [ City::class ], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {

        @Volatile
        private var instance: WeatherDatabase? = null

        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                WeatherDatabase::class.java,
                DATABASE_NAME
            )
                .createFromAsset("city.db")
                .fallbackToDestructiveMigration()
                .build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }
}