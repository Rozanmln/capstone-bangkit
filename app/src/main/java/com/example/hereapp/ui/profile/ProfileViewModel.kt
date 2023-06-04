package com.example.hereapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hereapp.data.repository.HereRepository

class ProfileViewModel(private val repo: HereRepository) : ViewModel() {
    fun getInfoHospitalSelf() = repo.getInfoHospital()
    fun getInfoHospitalAll() = repo.getInfoHospitalAll()
}