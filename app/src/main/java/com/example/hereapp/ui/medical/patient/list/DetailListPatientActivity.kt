package com.example.hereapp.ui.medical.patient.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.data.model.Predict
import com.example.hereapp.databinding.ActivityDetailListPatientBinding
import com.example.hereapp.ui.medical.patient.PatientViewModel
import com.example.hereapp.utils.Result

class DetailListPatientActivity : AppCompatActivity() {
    var mrid: String? = null
    var prid: String? = null
    private lateinit var binding: ActivityDetailListPatientBinding
    private lateinit var factory: ViewModelFactory
    private lateinit var patientViewModel: PatientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListPatientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        factory = ViewModelFactory.getInstance(this)
        patientViewModel = ViewModelProvider(this, factory)[PatientViewModel::class.java]

        mrid = intent.getStringExtra("MRID")
        prid = intent.getStringExtra("PRID")
        setDetail()
        btnDelete()

        if(mrid != null) {
            binding.btnDelete.visibility = View.GONE
        }


    }


    private fun btnDelete() {
        binding.btnDelete.setOnClickListener {
            if(prid != null) {
                patientViewModel.deletePredict(prid!!).observe(this) {
                    when(it) {
                        is Result.Success -> {
                            showText(it.data.msg)
                        }
                        is Result.Loading -> {}
                        is Result.Error -> {
                            showText(it.error)
                        }
                    }
                }
            }
            toMedRecord()
        }
    }

    private fun toMedRecord() {
        val fragmentManager = supportFragmentManager
        val listFragment = ListFragment()
        fragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main, listFragment, ListFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }

    private fun showText(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun setDetail() {
        if(mrid != null) {
            patientViewModel.getDetailMedRecordForPatient(mrid!!).observe(this) {
                when(it) {
                    is Result.Success -> {
                        bindData(it.data)
                    }
                    is Result.Loading -> {}
                    is Result.Error -> {
                        showText(it.error)
                    }
                }
            }
        }else if(prid != null) {
            patientViewModel.getPredictById(prid!!).observe(this) {
                when(it) {
                    is Result.Success -> {
                        bindDataPredict(it.data)
                    }
                    is Result.Loading -> {}
                    is Result.Error -> {
                        showText(it.error)
                    }
                }
            }
        }
    }

    private fun bindDataPredict(data: Predict) {
        val pattern = "\"(.*?)\"".toRegex()
        val matches = pattern.findAll(data.symptoms)

        var symptom = ""
        for (match in matches) {
            val extractedString = match.groupValues[1]
            symptom += extractedString + ", "
        }
        binding.apply {
            tvDate.text = data.createdAt
            tvKeluhan.text = symptom
            tvDiagnosis.text = data.disease + "(${data.description})"
            tvSaran.text = data.precaution
        }
    }

    private fun bindData(data: MedicalRecordDetail) {
        binding.apply {
            tvDate.text = data.createdAt
            tvKeluhan.text = data.symptom
            tvDiagnosis.text = data.diagnostic_results
            tvSaran.text = data.doctor_recommendation
            tvName.text = data.patientName
            tvNik.text = data.NIK
        }
    }

    companion object {
        var MRID = "MRID"
        var PRID = "PRID"
    }
}