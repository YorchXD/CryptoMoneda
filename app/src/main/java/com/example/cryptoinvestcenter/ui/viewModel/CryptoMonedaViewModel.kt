package com.example.cryptoinvestcenter.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cryptoinvestcenter.data.db.config.CryptoMonedasApp.Companion.prefs
import com.example.cryptoinvestcenter.data.repository.MonedaRepository

class CryptoMonedaViewModel: ViewModel() {
    private val repository = MonedaRepository()
    var monedas = repository.getAll().asLiveData()
    var detailMoneda = repository.getDetailMoneda(prefs.idMoneda!!).asLiveData()
}