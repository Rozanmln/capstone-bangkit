package com.example.hereapp.di

import android.content.Context
import com.example.hereapp.data.repository.HereRepository

object Injection {
    fun provideRepository(context: Context): HereRepository{
        return HereRepository()
    }
}