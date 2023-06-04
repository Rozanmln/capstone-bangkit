package com.example.hereapp.ui.medical.hospital

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.repository.HereRepository

class RecordHospitalViewModel(private val hereRepository: HereRepository): ViewModel(){

    fun getListMedicalRecord() = hereRepository.getListMedicalRecord()

    fun getDetail(id: String) = hereRepository.getDetailMedicalRecord(id)


}