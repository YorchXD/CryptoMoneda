package com.example.cryptoinvestcenter.data.network

import com.example.cryptoinvestcenter.data.model.DetailMoneda
import com.example.cryptoinvestcenter.data.model.Moneda
import com.example.cryptoinvestcenter.data.network.core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MonedaService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMonedas(): Response<List<Moneda>> {
        return withContext(Dispatchers.IO){
            retrofit.create(InterfaceService::class.java).getAll()
        }
    }

    suspend fun getMoneda(id:String): Response<DetailMoneda> {
        return withContext(Dispatchers.IO){
            retrofit.create(InterfaceService::class.java).getDetail(id)
        }
    }
}