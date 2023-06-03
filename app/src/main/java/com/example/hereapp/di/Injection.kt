package com.example.hereapp.di

import android.content.Context
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.data.remote.ApiConfig
import com.example.hereapp.data.repository.HereRepository

object Injection {
    fun provideRepository(context: Context): HereRepository{
        val pref = UserPreferences(context)
        val apiService = ApiConfig.hereAppService
        return HereRepository(pref, apiService)
    }
}