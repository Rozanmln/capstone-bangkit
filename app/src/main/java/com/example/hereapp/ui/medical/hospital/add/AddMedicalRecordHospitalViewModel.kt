package com.example.hereapp.ui.medical.hospital.add

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.MedicalRecordRequest
import com.example.hereapp.data.repository.HereRepository

class AddMedicalRecordHospitalViewModel(private val hereRepository: HereRepository): ViewModel() {
    fun postCreateMedicalRecord(request: MedicalRecordRequest) = hereRepository.postCreateMedicalRecord(request)
}