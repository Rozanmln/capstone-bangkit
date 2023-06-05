package com.example.hereapp.ui.medical.patient

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.repository.HereRepository

class PatientViewModel(private val repo: HereRepository): ViewModel() {
    fun getListMedRecordForPatient() = repo.getListMedRecordForPatient()
    fun getDetailMedRecordForPatient(id: String) = repo.getDetailMedRecordPatient(id)
}