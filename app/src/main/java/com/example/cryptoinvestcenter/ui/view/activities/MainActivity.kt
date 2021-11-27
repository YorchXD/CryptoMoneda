package com.example.cryptoinvestcenter.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinvestcenter.R
import com.example.cryptoinvestcenter.ui.view.fragments.CryptoMonedasFragment
import com.example.cryptoinvestcenter.ui.view.fragments.DetailMonedaFragment
import com.example.cryptoinvestcenter.ui.view.interfaces.IComunicateMoneda
import com.example.cryptoinvestcenter.ui.viewModel.CryptoMonedaViewModel

class MainActivity : AppCompatActivity(), IComunicateMoneda {
    private lateinit var viewModel: CryptoMonedaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(CryptoMonedaViewModel::class.java)
        setContentView(R.layout.activity_main)
        viewMonedas()
    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contentCryptoMonedasFragment, fragment)
        fragmentTransaction.commit()
    }

    override fun viewMonedas()
    {
        replaceFragment(CryptoMonedasFragment())
    }

    override fun viewDetailMoneda()
    {
        replaceFragment(DetailMonedaFragment())
    }
}