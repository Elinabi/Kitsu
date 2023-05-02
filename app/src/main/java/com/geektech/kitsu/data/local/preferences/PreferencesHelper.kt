package com.geektech.kitsu.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("kitsu.preferences", Context.MODE_PRIVATE)

    operator fun invoke() = preferences

//    private fun remote(key: String){
//        preferences.edit().remove(key).apply()
//    }

//    var isAuthorize: Boolean
//    get() = preferences.getBoolean("authorize", false)
//    set (value) = preferences.edit().putBoolean("authorize", value).apply()
}

//private val preference: SharedPreferences =
//    context.getSharedPreferences("userStatus", Context.MODE_PRIVATE)
//
//operator fun invoke() = preference