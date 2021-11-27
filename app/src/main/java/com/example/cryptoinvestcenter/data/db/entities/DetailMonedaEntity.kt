package com.example.cryptoinvestcenter.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_moneda_entity")
data class DetailMonedaEntity (
    @ColumnInfo(name = "id") @PrimaryKey val id : String,
    @ColumnInfo(name = "currency") val currency : String,
    @ColumnInfo(name = "symbol") val symbol : String,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "logo_url") val logo_url : String,
    @ColumnInfo(name = "status") val status : String,
    @ColumnInfo(name = "price") val price : Double,
    @ColumnInfo(name = "price_date") val price_date : String,
    @ColumnInfo(name = "price_timestamp") val price_timestamp : String,
    @ColumnInfo(name = "circulating_supply") val circulating_supply : Long,
    @ColumnInfo(name = "market_cap") val market_cap : Long,
    @ColumnInfo(name = "num_exchanges") val num_exchanges : Int,
    @ColumnInfo(name = "num_pairs") val num_pairs : Int,
    @ColumnInfo(name = "num_pairs_unmapped") val num_pairs_unmapped : Int,
    @ColumnInfo(name = "first_candle") val first_candle : String,
    @ColumnInfo(name = "first_trade") val first_trade : String,
    @ColumnInfo(name = "first_order_book") val first_order_book : String,
    @ColumnInfo(name = "rank") val rank : Int,
    @ColumnInfo(name = "rank_delta") val rank_delta : Int,
    @ColumnInfo(name = "high") val high : Double,
    @ColumnInfo(name = "high_timestamp") val high_timestamp : String
)