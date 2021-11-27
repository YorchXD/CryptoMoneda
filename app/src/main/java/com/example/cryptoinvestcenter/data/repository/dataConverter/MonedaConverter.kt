package com.example.cryptoinvestcenter.data.repository.dataConverter

import com.example.cryptoinvestcenter.data.db.entities.DetailMonedaEntity
import com.example.cryptoinvestcenter.data.db.entities.MonedaEntity
import com.example.cryptoinvestcenter.data.model.DetailMoneda
import com.example.cryptoinvestcenter.data.model.Moneda

class MonedaConverter {
    companion object{
        fun converterMonedasEntity(monedas: List<Moneda>): List<MonedaEntity>
        {
            val monedasEntity = mutableListOf<MonedaEntity>()
            monedas.map {

                monedasEntity.add(MonedaEntity(it.id, it.currency, it.symbol, it.name, it.logo_url, it.status, it.price, it.price_date,
                it.price_timestamp, it.rank))
            }
            return monedasEntity
        }

        fun converterMonedas(monedasEntity: List<MonedaEntity>): List<Moneda>
        {
            val monedas = mutableListOf<Moneda>()
            monedasEntity.map {
                monedas.add(Moneda(it.id, it.currency, it.symbol, it.name, it.logo_url, it.status, it.price, it.price_date,
                    it.price_timestamp, it.rank))
            }
            return monedas
        }

        fun converterDetailMonedaEntity(detailMoneda: DetailMoneda): DetailMonedaEntity
        {
            return DetailMonedaEntity(detailMoneda.id, detailMoneda.currency, detailMoneda.symbol, detailMoneda.name, detailMoneda.logo_url,
                detailMoneda.status, detailMoneda.price, detailMoneda.price_date, detailMoneda.price_timestamp, detailMoneda.circulating_supply,
                detailMoneda.market_cap, detailMoneda.num_exchanges, detailMoneda.num_pairs, detailMoneda.num_pairs_unmapped, detailMoneda.first_candle,
                detailMoneda.first_trade, detailMoneda.first_order_book, detailMoneda.rank, detailMoneda.rank_delta, detailMoneda.high, detailMoneda.high_timestamp)
        }

        fun converterDetailMoneda(detailMonedaEntity: DetailMonedaEntity): DetailMoneda
        {
            return DetailMoneda(detailMonedaEntity.id, detailMonedaEntity.currency, detailMonedaEntity.symbol, detailMonedaEntity.name, detailMonedaEntity.logo_url,
                detailMonedaEntity.status, detailMonedaEntity.price, detailMonedaEntity.price_date, detailMonedaEntity.price_timestamp, detailMonedaEntity.circulating_supply,
                detailMonedaEntity.market_cap, detailMonedaEntity.num_exchanges, detailMonedaEntity.num_pairs, detailMonedaEntity.num_pairs_unmapped, detailMonedaEntity.first_candle,
                detailMonedaEntity.first_trade, detailMonedaEntity.first_order_book, detailMonedaEntity.rank, detailMonedaEntity.rank_delta, detailMonedaEntity.high, detailMonedaEntity.high_timestamp)
        }
    }
}