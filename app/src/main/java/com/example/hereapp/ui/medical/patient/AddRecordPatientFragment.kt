package com.example.hereapp.ui.medical.patient

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.adapter.medical.RecordHospitalAdapter
import com.example.hereapp.adapter.patient.AddDiagnosisAdapter
import com.example.hereapp.adapter.patient.DiagnosisSearchAdapter
import com.example.hereapp.data.model.InputSymptom
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.databinding.FragmentAddRecordPatientBinding
import com.example.hereapp.dummy.DataDummy
import com.example.hereapp.ui.medical.hospital.DetailRecordHospitalFragment
import com.example.hereapp.utils.Result


class AddRecordPatientFragment : Fragment() {
    private var list = ArrayList<Symptom>()
    private lateinit var factory: ViewModelFactory
    private lateinit var recordPatientViewModel: PatientViewModel
    private val listSymptom = ArrayList<Symptom>()
    private var _binding: FragmentAddRecordPatientBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRecordPatientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = ViewModelFactory.getInstance(requireActivity())
        recordPatientViewModel = ViewModelProvider(this, factory)[PatientViewModel::class.java]

        list = DataDummy.generateSymptomData()
        searchSymptom()
    }

    private fun showRecyclerSymptom(list: ArrayList<Symptom>) {
        val adapter = AddDiagnosisAdapter(list)
        binding.rvSymptom.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvSymptom.setHasFixedSize(true)
        binding.rvSymptom.adapter = adapter

    }

    private fun searchSymptom() {
        binding.edtSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                showRecyclerSearch(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    private fun showRecyclerSearch(query: String) {
        if(query.isNotEmpty()) {
            binding.rvListSymptom.visibility = View.VISIBLE
        }else {
            binding.rvListSymptom.visibility = View.GONE
        }
        val newList = list.filter {
            it.symptomName.contains(query, ignoreCase = true)
        }

        val adapter = DiagnosisSearchAdapter(newList as ArrayList<Symptom>)

        binding.rvListSymptom.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvListSymptom.setHasFixedSize(true)
        binding.rvListSymptom.adapter = adapter

        adapter.setOnItemClickCallback(object: DiagnosisSearchAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Symptom) {
                listSymptom.add(data)
                showRecyclerSymptom(listSymptom)
            }

        })

    }
    private fun getData(): ArrayList<Symptom> {
        var newList = ArrayList<Symptom>()

        recordPatientViewModel.getSymptom().observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                   newList = it.data as ArrayList<Symptom>
                    showText(newList.toString())
                }
                is Result.Loading -> {
                    showLoading(true)
                }
                is Result.Error -> {
                    showLoading(false)
                    showText(it.error)
                }
            }
        }
        return newList
    }

    private fun showLoading(state: Boolean){
        if (state) binding.progressBar.visibility = View.VISIBLE
        else binding.progressBar.visibility = View.GONE
    }

    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }


}