package com.example.foodorderingapplication.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    companion object {
        const val TOKEN = "com.example.fooddeliveryapp.TOKEN"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN, token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN, "")
    }

}