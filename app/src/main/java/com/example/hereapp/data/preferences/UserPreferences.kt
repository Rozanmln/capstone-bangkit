package com.example.hereapp.data.preferences

import android.content.Context
import com.example.hereapp.data.model.UserSession

class UserPreferences(context: Context) {
    companion object {
        private const val isLogin = "isLogin"
        private const val name = "name"
        private const val token = "token"
        private const val role = "role"
    }

    private val preferences = context.getSharedPreferences(isLogin, Context.MODE_PRIVATE)


    fun setPref(pref: UserSession) {
        val editor = preferences.edit()
        editor.putBoolean(isLogin, pref.isLogin!!)
        editor.putString(name, pref.name)
        editor.putString(token, pref.token)
        editor.putInt(role, pref.role!!)

        editor.apply()
    }

    fun getPref(): UserSession {
        val model = UserSession()
        model.isLogin = preferences.getBoolean(isLogin, false)
        model.name = preferences.getString(name, "")
        model.token = preferences.getString(token, "")
        model.role = preferences.getInt(role, 0)

        return model
    }

    fun clearSession() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}