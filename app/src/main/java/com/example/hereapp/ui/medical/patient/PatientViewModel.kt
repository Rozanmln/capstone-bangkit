package com.example.hereapp.ui.medical.patient

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.repository.HereRepository
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray

class PatientViewModel(private val repo: HereRepository): ViewModel() {
    fun getListMedRecordForPatient() = repo.getListMedRecordForPatient()
    fun getDetailMedRecordForPatient(id: String) = repo.getDetailMedRecordPatient(id)

    fun postCreatePredict(json: JsonObject) = repo.postCreatePredict(json)
    fun getSymptom() = repo.getSymptom()

    fun getListPredict() = repo.getListPredict()

    fun getPredictById(id: String) = repo.getPredictById(id)

    fun deletePredict(id: String) = repo.deletePredict(id)

    fun getSearchPredict(query: String) = repo.getSearchPredict(query)
}