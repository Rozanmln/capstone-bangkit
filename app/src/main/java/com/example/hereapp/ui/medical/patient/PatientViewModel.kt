package com.example.hereapp.ui.medical.patient

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.PredictSymptom
import com.example.hereapp.data.repository.HereRepository
import com.google.gson.JsonArray

class PatientViewModel(private val repo: HereRepository): ViewModel() {
    fun getListMedRecordForPatient() = repo.getListMedRecordForPatient()
    fun getDetailMedRecordForPatient(id: String) = repo.getDetailMedRecordPatient(id)

    fun postCreatePredict(list: List<PredictSymptom>) = repo.postCreatePredict(list)
    fun getSymptom() = repo.getSymptom()
}