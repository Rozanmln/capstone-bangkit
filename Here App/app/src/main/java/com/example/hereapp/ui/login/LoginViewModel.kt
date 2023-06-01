package com.example.hereapp.ui.login

import androidx.lifecycle.ViewModel
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.repository.HereRepository

class LoginViewModel(private val repo: HereRepository): ViewModel() {

    fun postLoginPatient(request: LoginRequest) = repo.postLoginPatient(request)

    fun postLoginHospital(request: LoginRequest) = repo.postLoginHospital(request)
}