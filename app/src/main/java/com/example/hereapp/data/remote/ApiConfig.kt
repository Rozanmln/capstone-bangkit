package com.example.hereapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiConfig {
    private val okHttp = OkHttpClient.Builder()
        .apply {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(loggingInterceptor)
        }.build()

    private val retrofit = Retrofit.Builder()
        .client(okHttp)
        .baseUrl("https://here-app-ripfuystpa-uc.a.run.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val hereAppService = retrofit.create<HereAppService>()
}