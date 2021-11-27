package com.example.cryptoinvestcenter.data.db.config

import android.app.Application
import androidx.room.Room
import com.example.cryptoinvestcenter.data.db.Prefs

class CryptoMonedasApp: Application() {
    companion object{
        lateinit var db: DB
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            DB::class.java,
            "cryptoinvestcenter"
        ).build()

        prefs = Prefs(applicationContext)
    }
}