package com.example.hereapp.data.remote

import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.model.LoginResponse
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterHospitalResponse
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.model.RegisterPatientResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface HereAppService {
    @POST("hospital")
    suspend fun postRegisterHospital(
        @Body request: RegisterHospitalRequest
    ): RegisterHospitalResponse

    @POST("patient")
    suspend fun postRegisterPatient(
        @Body request: RegisterPatientRequest
    ): RegisterPatientResponse

    @POST("loginHospital")
    suspend fun postLoginHospital(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("loginPatient")
    suspend fun postLoginPatient(
        @Body request: LoginRequest
    ): LoginResponse
}