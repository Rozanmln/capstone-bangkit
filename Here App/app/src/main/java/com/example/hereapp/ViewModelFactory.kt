package com.example.hereapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.data.repository.HereRepository
import com.example.hereapp.di.Injection

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repo: HereRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return when {

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