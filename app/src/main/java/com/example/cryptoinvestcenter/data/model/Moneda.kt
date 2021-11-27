package com.example.cryptoinvestcenter.data.model
import com.google.gson.annotations.SerializedName

data class Moneda (
    @SerializedName("id") val id : String,
    @SerializedName("currency") val currency : String,
    @SerializedName("symbol") val symbol : String,
    @SerializedName("name") val name : String,
    @SerializedName("logo_url") val logo_url : String,
    @SerializedName("status") val status : String,
    @SerializedName("price") val price : Double,
    @SerializedName("price_date") val price_date : String,
    @SerializedName("price_timestamp") val price_timestamp : String,
    @SerializedName("rank") val rank : Int

)