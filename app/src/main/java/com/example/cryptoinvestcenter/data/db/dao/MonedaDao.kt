package com.example.cryptoinvestcenter.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoinvestcenter.data.db.entities.DetailMonedaEntity
import com.example.cryptoinvestcenter.data.db.entities.MonedaEntity
import org.jetbrains.annotations.NotNull

@Dao
interface MonedaDao {
    @Query("SELECT * FROM moneda_entity")
    suspend fun getAll(): List<MonedaEntity>

    @Query("SELECT * FROM detail_moneda_entity WHERE detail_moneda_entity.id =:id")
    suspend fun getDetailMoneda(@NotNull id: String): DetailMonedaEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonedas(@NotNull monedas:List<MonedaEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailMoneda(@NotNull detailMoneda:DetailMonedaEntity)
}
