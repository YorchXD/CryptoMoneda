package com.example.cryptoinvestcenter.data.network.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://fake-server-app-crypto.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}