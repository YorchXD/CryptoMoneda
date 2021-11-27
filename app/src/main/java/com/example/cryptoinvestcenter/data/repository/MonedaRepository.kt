package com.example.cryptoinvestcenter.data.repository

import android.util.Log
import com.example.cryptoinvestcenter.data.db.config.CryptoMonedasApp.Companion.db
import com.example.cryptoinvestcenter.data.db.entities.DetailMonedaEntity
import com.example.cryptoinvestcenter.data.db.entities.MonedaEntity
import com.example.cryptoinvestcenter.data.model.DetailMoneda
import com.example.cryptoinvestcenter.data.model.Moneda
import com.example.cryptoinvestcenter.data.network.MonedaService
import com.example.cryptoinvestcenter.data.repository.dataConverter.MonedaConverter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MonedaRepository {
    private val monedaService = MonedaService()

    fun getAll(): Flow<List<Moneda>> = flow {
        while(true)
        {
            val monedaResponse = kotlin.runCatching { monedaService.getMonedas() }

            monedaResponse.onSuccess {
                if(it.body()!=null)
                {
                    db.monedaDAO().insertMonedas(MonedaConverter.converterMonedasEntity(it.body()!!))
                }
            }

            monedaResponse.onFailure {
                Log.d("Error Moneda", it.toString())
            }

            val monedasEntity: List<MonedaEntity> = db.monedaDAO().getAll()

            if(monedasEntity!=null)
            {
                emit(MonedaConverter.converterMonedas(monedasEntity))
            }

            delay(5000)
        }

    }.flowOn(Dispatchers.IO)

    fun getDetailMoneda(id:String): Flow<DetailMoneda> = flow {
        while(true)
        {
            val monedaResponse = kotlin.runCatching { monedaService.getMoneda(id) }

            monedaResponse.onSuccess {
                Log.d("DetailMoneda", it.body().toString())
                if(it.body()!=null)
                {
                    db.monedaDAO().insertDetailMoneda(MonedaConverter.converterDetailMonedaEntity(it.body()!!))
                }
            }

            monedaResponse.onFailure {
                Log.d("ErrorDetailMoneda", it.toString())
            }

            val detailMonedaEntity: DetailMonedaEntity = db.monedaDAO().getDetailMoneda(id)

            if(detailMonedaEntity!=null)
            {
                emit(MonedaConverter.converterDetailMoneda(detailMonedaEntity))
            }

            delay(5000)
        }

    }.flowOn(Dispatchers.IO)
}