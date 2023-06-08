package com.example.hereapp.data.remote

import com.example.hereapp.data.model.InfoHospitalResponse
import com.example.hereapp.data.model.InfoPatientResponse
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.model.LoginResponse
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.data.model.MedicalRecordRequest
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.model.RegisterPatientResponse
import com.example.hereapp.data.model.Response
import com.example.hereapp.data.model.Symptom
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


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

    @PATCH("hospital")
    suspend fun patchEditHospital(
        @Header("Authorization") token: String,
        @Body request: RegisterHospitalRequest
    ): Response

    @DELETE("hospital")
    suspend fun deleteHospital(
        @Header("Authorization") token: String
    ): Response

    @POST("medRecord")
    suspend fun postCreateMedicalRecord(
        @Header("Authorization") token: String,
        @Body request: MedicalRecordRequest
    ): Response

    @GET("medRecordforHospital")
    suspend fun getListMedicalRecordForHospital(
        @Header("Authorization") token: String
    ): List<MedicalRecord>

    @GET("medRecordforHospital/{id}")
    suspend fun getDetailMedRecordHospital(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): MedicalRecordDetail

    @GET("searchMedRecordforHospital")
    suspend fun searchMedRecord(
        @Header("Authorization") token: String,
        @Query("input") input: String
    ): List<MedicalRecord>

    @GET("patientbyid")
    suspend fun getInfoPatientSelf(
        @Header("Authorization") token: String,
    ): InfoPatientResponse

    @PATCH("patient")
    suspend fun patchEditPatient(
        @Header("Authorization") token: String,
        @Body request: RegisterPatientRequest
    ): Response

    @DELETE("patient")
    suspend fun deletePatient(
        @Header("Authorization") token: String,
    ): Response

    @GET("medRecordforPatient")
    suspend fun getListMedRecordForPatient(
        @Header("Authorization") token: String
    ): List<MedicalRecord>

    @GET("medRecordforPatient/{id}")
    suspend fun getDetailMedRecordPatient(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): MedicalRecordDetail

    @PATCH("medRecord/{id}")
    suspend fun patchEditMedicalRecord(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body request: MedicalRecordRequest
    ): Response

    @DELETE("medRecord/{id}")
    suspend fun deleteMedicalRecord(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response

    @GET("symptom")
    suspend fun getSymptom(
        @Header("Authorization") token: String
    ): List<Symptom>

    @POST("predict")
    suspend fun postCreatePredict(
        @Header("Authorization") token: String,
        @Body symptoms: List<Symptom>
    ): Response
}