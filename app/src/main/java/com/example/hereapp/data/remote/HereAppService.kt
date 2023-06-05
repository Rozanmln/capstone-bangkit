package com.example.hereapp.data.remote

import com.example.hereapp.data.model.InfoHospitalResponse
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.model.LoginResponse
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.data.model.MedicalRecordRequest
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.model.RegisterPatientResponse
import com.example.hereapp.data.model.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface HereAppService {
    @POST("hospital")
    suspend fun postRegisterHospital(
        @Body request: RegisterHospitalRequest
    ): Response

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

    @GET("hospitalbyid")
    suspend fun getInfoHospitalSelf(
        @Header("Authorization") token: String
    ): InfoHospitalResponse

    @GET("hospitalbyid")
    suspend fun getInfoHospitalAll(
        @Header("Authorization") token: String
    ): List<InfoHospitalResponse>

    @POST("medRecord")
    suspend fun postCreateMedicalRecord(
        @Header("Authorization") token: String,
        @Body request: MedicalRecordRequest
    ): Response

    @GET("medRecord")
    suspend fun getListMedicalRecord(
        @Header("Authorization") token: String
    ): List<MedicalRecord>

    @GET("medRecord/{id}")
    suspend fun getDetailMedRecord(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): MedicalRecordDetail
}