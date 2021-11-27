package com.example.cryptoinvestcenter

import com.example.cryptoinvestcenter.data.db.config.CryptoMonedasApp
import com.example.cryptoinvestcenter.data.db.config.CryptoMonedasApp.Companion.prefs
import com.example.cryptoinvestcenter.ui.viewModel.CryptoMonedaViewModel
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class CryptoMonedaViewModelTest {

    @Test
    fun prefsTest()
    {
        prefs.idMoneda = "ADA"
        Assert.assertEquals("ADA", prefs.idMoneda)
    }




    /*@get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun moneda() = runBlockingTest {
        ///val repository = MoviesRepository(FakeLocalDataSource(), FakeRemoteDataSource(fakeMovies))
        val vm = CryptoMonedaViewModel()
        prefs.idMoneda = "ADA"
        Assert.assertEquals("Cardano", vm.detailMoneda.value?.name)

    }*/
}