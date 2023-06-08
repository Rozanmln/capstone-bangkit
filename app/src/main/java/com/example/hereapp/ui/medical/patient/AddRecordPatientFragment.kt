package com.example.hereapp.ui.medical.patient

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.adapter.patient.AddDiagnosisAdapter
import com.example.hereapp.adapter.patient.DiagnosisSearchAdapter
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.databinding.FragmentAddRecordPatientBinding
import com.example.hereapp.dummy.DataDummy
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
        btnSubmit()
    }

    private fun btnSubmit() {
        binding.btnSubmit.setOnClickListener {
            if(listSymptom.isNotEmpty()) {
                val fragmentManager = parentFragmentManager
                val detailFragment = DetailRecordPatientFragment()
                fragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_activity_main, detailFragment, DetailRecordPatientFragment::class.java.simpleName)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    commit()
                }
            }else {
                showText("Masukkan Keluhan Terlebih Dahulu")
            }
        }
    }

    private fun showRecyclerSymptom(list: ArrayList<Symptom>) {
        val newList = list
        val adapter = AddDiagnosisAdapter(newList)
        binding.rvSymptom.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvSymptom.setHasFixedSize(true)
        binding.rvSymptom.adapter = adapter

        adapter.setOnItemClickCallback(object: AddDiagnosisAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Symptom) {
                newList.remove(data)
                showRecyclerSymptom(newList)
            }
        })

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
                if(!listSymptom.contains(data))
                    listSymptom.add(data)
                else showText("Sudah anda Tambahkan")
                showRecyclerSymptom(listSymptom)
            }

        })

    }
    private fun getData(): ArrayList<Symptom> {
        var newList = ArrayList<Symptom>()

        recordPatientViewModel.getSymptom().observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    showText(it.data.toString())

                }
                is Result.Loading -> {}
                is Result.Error -> {
                    showText(it.error)
                }
            }
        }
        return newList
    }


    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }

}