package com.example.hereapp.ui.register

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.data.repository.HereRepository

class RegisterViewModel(private val repo: HereRepository): ViewModel() {
    fun postRegisterHospital(request: RegisterHospitalRequest) = repo.postRegisterHospital(request)

    fun postRegisterPatient(request: RegisterPatientRequest) = repo.postRegisterPatient(request)
}