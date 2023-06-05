package com.example.hereapp.ui.medical.hospital

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.data.repository.HereRepository

class RecordHospitalViewModel(private val hereRepository: HereRepository): ViewModel(){

    fun getListMedicalRecordForHospital() = hereRepository.getListMedicalRecordForHospital()
    fun getDetail(id: String) = hereRepository.getDetailMedicalRecordHospital(id)
    fun deleteMedicalRecord(id: String) = hereRepository.deleteMedicalRecord(id)
}