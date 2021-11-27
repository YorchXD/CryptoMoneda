package com.example.cryptoinvestcenter.data.network

import com.example.cryptoinvestcenter.data.model.DetailMoneda
import com.example.cryptoinvestcenter.data.model.Moneda
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceService {
    @GET("general/")
    suspend fun getAll(): Response<List<Moneda>>

    @GET("details/{id}")
    suspend fun getDetail(@Path("id") id:String) : Response<DetailMoneda>
}