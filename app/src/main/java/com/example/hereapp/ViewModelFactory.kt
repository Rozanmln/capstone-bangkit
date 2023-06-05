package com.example.hereapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.data.repository.HereRepository
import com.example.hereapp.di.Injection
import com.example.hereapp.ui.login.LoginViewModel
import com.example.hereapp.ui.medical.hospital.add.AddMedicalRecordHospitalViewModel
import com.example.hereapp.ui.medical.hospital.RecordHospitalViewModel
import com.example.hereapp.ui.profile.ProfileViewModel
import com.example.hereapp.ui.register.RegisterViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repo: HereRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return when {
           modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
               LoginViewModel(repo) as T
           }
           modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
               RegisterViewModel(repo) as T
           }
           modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
               ProfileViewModel(repo) as T
           }
           modelClass.isAssignableFrom(AddMedicalRecordHospitalViewModel::class.java) -> {
               AddMedicalRecordHospitalViewModel(repo) as T
           }
           modelClass.isAssignableFrom(RecordHospitalViewModel::class.java) -> {
               RecordHospitalViewModel(repo) as T
           }
           else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
       }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory {
            return instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
        }
    }
}