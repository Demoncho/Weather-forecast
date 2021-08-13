package ru.solntsev.android.weatherforecast.model.database.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Update
    fun update(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<T>)

    @Delete
    fun delete(item: T)
}