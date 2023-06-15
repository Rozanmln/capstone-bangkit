package com.example.hereapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.hereapp.data.model.InfoHospitalResponse
import com.example.hereapp.data.model.InfoPatientResponse
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.model.LoginResponse
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.data.model.MedicalRecordRequest
import com.example.hereapp.data.model.Predict
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.model.RegisterPatientResponse
import com.example.hereapp.data.model.Response
import com.example.hereapp.data.model.ResponsePredict
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.data.remote.HereAppService
import com.example.hereapp.utils.Result
import com.google.gson.JsonObject


class HereRepository(private val pref: UserPreferences, private val apiService: HereAppService) {

    fun getListMedicalRecordForHospital(): LiveData<Result<List<MedicalRecord>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getListMedicalRecordForHospital(token)
            emit(Result.Success(response))

        } catch (e: Exception) {
            Log.d("getListMedicalRecordForHospital", e.message.toString())
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
            Log.d("postCreateMedicalRecord", e.message.toString())
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
            Log.d("getInfoHospitalAll", e.message.toString())
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
            Log.d("getInfoHospital", e.message.toString())
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
            Log.d("postLoginHospital", e.message.toString())
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
            Log.d("postLoginPatient", e.message.toString())
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
            Log.d("postRegisterPatient", e.message.toString())
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
            Log.d("postRegisterHospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }


    fun getDetailMedicalRecordHospital(id: String): LiveData<Result<MedicalRecordDetail>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getDetailMedRecordHospital(token, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getDetailMedicalRecordHospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun patchEditHospital(request: RegisterHospitalRequest): LiveData<Result<Response>> = liveData{
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .patchEditHospital(token, request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("patchEditHospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun deleteHospital(): LiveData<Result<Response>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .deleteHospital(token)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("deleteHospital", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getInfoPatientSelf(): LiveData<Result<InfoPatientResponse>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getInfoPatientSelf(token)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getInfoPatientSelf", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun patchEditPatient(request: RegisterPatientRequest): LiveData<Result<Response>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .patchEditPatient(token, request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("patchEditPatient", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun deletePatient(): LiveData<Result<Response>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .deletePatient(token)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("deltePatient", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getListMedRecordForPatient(): LiveData<Result<List<MedicalRecord>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getListMedRecordForPatient(token)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getListMedicalRecordForPatient", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getDetailMedRecordPatient(id: String): LiveData<Result<MedicalRecordDetail>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getDetailMedRecordPatient(token, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getDetailMedicalRecord", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun patchEditMedicalRecord(id: String, request: MedicalRecordRequest): LiveData<Result<Response>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .patchEditMedicalRecord(token, id, request)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("patchEditMedicalRecord", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun deleteMedicalRecord(id: String): LiveData<Result<Response>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .deleteMedicalRecord(token, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("deleteMedicalRecord", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun searchMedRecord(query: String): LiveData<Result<List<MedicalRecord>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .searchMedRecord(token, query)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("searchMedicalRecord", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getSymptom(): LiveData<Result<List<Symptom>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getSymptom(token)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getSymptom", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun postCreatePredict(json: JsonObject): LiveData<Result<ResponsePredict>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .postCreatePredict(token, json)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("createPredict", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun getListPredict(): LiveData<Result<List<Predict>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getListPredict(token)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("createPredict", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun getPredictById(id: String): LiveData<Result<Predict>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getPredictById(token, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getPredictById", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
    fun deletePredict(id: String): LiveData<Result<Response>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .deletePredict(token, id)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getPredictById", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getSearchPredict(query: String): LiveData<Result<List<Predict>>> = liveData {
        val token = "Bearer ${pref.getPref().token}"
        emit(Result.Loading)
        try {
            val response = apiService
                .getSearchPredict(token, query)
            emit(Result.Success(response))
        } catch (e: Exception) {
            Log.d("getPredictById", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }
}

