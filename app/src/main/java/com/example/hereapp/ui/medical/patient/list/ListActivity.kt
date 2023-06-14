package com.example.hereapp.ui.medical.patient.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.Predict
import com.example.hereapp.databinding.ActivityListBinding
import com.example.hereapp.databinding.FragmentListBinding
import com.example.hereapp.ui.medical.patient.PatientViewModel

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private val list = ArrayList<MedicalRecord>()
    private val listPredict = ArrayList<Predict>()
    private lateinit var factory: ViewModelFactory
    private lateinit var patientViewModel: PatientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        factory = ViewModelFactory.getInstance(this)
        patientViewModel = ViewModelProvider(this, factory)[PatientViewModel::class.java]

        showRecyclerView()
    }

    private fun showRecyclerView() {

    }

}