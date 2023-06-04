package com.example.hereapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
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
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.data.remote.HereAppService
import com.example.hereapp.utils.Result


class HereRepository(private val pref: UserPreferences, private val apiService: HereAppService) {

    fun getListMedicalRecord(): LiveData<Result<List<MedicalRecord>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getListMedicalRecord(token)
            emit(Result.Success(response))

        } catch (e: Exception) {
            Log.d("List_Medical_Record", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun postCreateMedicalRecord(request: MedicalRecordRequest): LiveData<Result<Response>>  = liveData {
        val token = "Bearer ${pref.getPref().token}"

        emit(Result.Loading)
        try {
            val response = apiService
                .postCreateMedicalRecord(token, request)
            emit(Result.Success(response))

        } catch (e: Exception) {
            Log.d("Info_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getInfoHospitalAll(): LiveData<Result<List<InfoHospitalResponse>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"

        emit(Result.Loading)
        try {
            val response = apiService
                .getInfoHospitalAll(token)
            emit(Result.Success(response))

        } catch (e: Exception) {
            Log.d("Info_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun getInfoHospital(): LiveData<Result<InfoHospitalResponse>> = liveData {
        val token = "Bearer ${pref.getPref().token}"

        emit(Result.Loading)
        try {
            val response = apiService
                .getInfoHospitalSelf(token)
            emit(Result.Success(response))

        } catch (e: Exception) {
            Log.d("Info_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun postLoginHospital(request: LoginRequest): LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService
                .postLoginHospital(request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("Login_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun postLoginPatient(request: LoginRequest): LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService
                .postLoginPatient(request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("Login_Patient", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun postRegisterPatient(request: RegisterPatientRequest): LiveData<Result<RegisterPatientResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService
                .postRegisterPatient(request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("Register_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun postRegisterHospital(request: RegisterHospitalRequest): LiveData<Result<Response>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService
                .postRegisterHospital(request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("Register_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }


    fun getDetailMedicalRecord(id: String): LiveData<Result<MedicalRecordDetail>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getDetailMedRecord(token, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("Register_Hospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
}