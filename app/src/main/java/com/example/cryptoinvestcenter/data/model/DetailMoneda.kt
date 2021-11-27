package com.example.cryptoinvestcenter.data.model

import com.google.gson.annotations.SerializedName

data class DetailMoneda(
    @SerializedName("id") val id : String,
    @SerializedName("currency") val currency : String,
    @SerializedName("symbol") val symbol : String,
    @SerializedName("name") val name : String,
    @SerializedName("logo_url") val logo_url : String,
    @SerializedName("status") val status : String,
    @SerializedName("price") val price : Double,
    @SerializedName("price_date") val price_date : String,
    @SerializedName("price_timestamp") val price_timestamp : String,
    @SerializedName("circulating_supply") val circulating_supply : Long,
    @SerializedName("market_cap") val market_cap : Long,
    @SerializedName("num_exchanges") val num_exchanges : Int,
    @SerializedName("num_pairs") val num_pairs : Int,
    @SerializedName("num_pairs_unmapped") val num_pairs_unmapped : Int,
    @SerializedName("first_candle") val first_candle : String,
    @SerializedName("first_trade") val first_trade : String,
    @SerializedName("first_order_book") val first_order_book : String,
    @SerializedName("rank") val rank : Int,
    @SerializedName("rank_delta") val rank_delta : Int,
    @SerializedName("high") val high : Double,
    @SerializedName("high_timestamp") val high_timestamp : String
)
