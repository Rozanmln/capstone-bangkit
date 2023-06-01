package com.example.hereapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.model.LoginResponse
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterHospitalResponse
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.model.RegisterPatientResponse
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.data.remote.HereAppService
import com.example.hereapp.utils.Result
import java.lang.Exception

class HereRepository(private val pref: UserPreferences, private val apiService: HereAppService) {

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

    fun postRegisterHospital(request: RegisterHospitalRequest): LiveData<Result<RegisterHospitalResponse>> = liveData {
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
}