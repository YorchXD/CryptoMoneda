package com.example.cryptoinvestcenter.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "moneda_entity")
data class MonedaEntity(
    @ColumnInfo(name = "id") @PrimaryKey val id : String,
    @ColumnInfo(name = "currency") val currency : String,
    @ColumnInfo(name = "symbol") val symbol : String,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "logo_url") val logo_url : String,
    @ColumnInfo(name = "status") val status : String,
    @ColumnInfo(name = "price") val price : Double,
    @ColumnInfo(name = "price_date") val price_date : String,
    @ColumnInfo(name = "price_timestamp") val price_timestamp : String,
    @ColumnInfo(name = "rank") val rank : Int
)
