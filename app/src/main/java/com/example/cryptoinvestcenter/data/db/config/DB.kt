package com.example.cryptoinvestcenter.data.db.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptoinvestcenter.data.db.dao.MonedaDao
import com.example.cryptoinvestcenter.data.db.entities.DetailMonedaEntity
import com.example.cryptoinvestcenter.data.db.entities.MonedaEntity

@Database(
    entities = [MonedaEntity::class, DetailMonedaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DB : RoomDatabase() {
    abstract fun monedaDAO(): MonedaDao
}