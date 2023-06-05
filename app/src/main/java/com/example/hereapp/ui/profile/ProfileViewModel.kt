package com.example.hereapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.repository.HereRepository

class ProfileViewModel(private val repo: HereRepository) : ViewModel() {
    fun getInfoHospitalSelf() = repo.getInfoHospital()
    fun getInfoHospitalAll() = repo.getInfoHospitalAll()
    fun patchEditHospital(request: RegisterHospitalRequest) = repo.patchEditHospital(request)
    fun deleteHospital() = repo.deleteHospital()
    fun getInfoPatientSelf() = repo.getInfoPatientSelf()
    fun patchEditPatient(request: RegisterPatientRequest) = repo.patchEditPatient(request)
    fun deletePatient() = repo.deletePatient()
}