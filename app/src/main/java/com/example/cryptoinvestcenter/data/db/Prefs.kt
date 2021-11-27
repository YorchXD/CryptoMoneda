package com.example.cryptoinvestcenter.data.db

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val PREFS_NAME = "com.example.cryptoinvestcenter"
    private val SHARED_ID_BOOK = "shared_id_moneda"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var idMoneda: String?
        get() = prefs.getString(SHARED_ID_BOOK, "")
        set(value) = prefs.edit().putString(SHARED_ID_BOOK, value!!).apply()
}