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
import com.example.hereapp.adapter.patient.DiagnosisAdapter
import com.example.hereapp.data.model.InputSymptom
import com.example.hereapp.data.model.ResponsePredict
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.databinding.FragmentAddRecordPatientBinding
import com.example.hereapp.utils.Result
import com.google.gson.JsonObject


class AddRecordPatientFragment : Fragment() {
    private var list = ArrayList<InputSymptom>()
    private val listSymptom = ArrayList<InputSymptom>()
    private lateinit var jsonObjectOfSymptom: JsonObject
    private lateinit var factory: ViewModelFactory
    private lateinit var recordPatientViewModel: PatientViewModel
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

        jsonObjectOfSymptom = JsonObject()
        getData()
        searchSymptom()
        btnSubmit()
    }

    private fun btnSubmit() {
        binding.btnSubmit.setOnClickListener {
            if(jsonObjectOfSymptom.toString() != "{}") {
               postPredict(jsonObjectOfSymptom)
            }else {
                showText("Masukkan Keluhan Terlebih Dahulu")
            }
        }
    }

    private fun postPredict(data: JsonObject) {
        recordPatientViewModel.postCreatePredict(data).observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    toDetail(it.data)
                }
                is Result.Loading -> {}
                is Result.Error -> {
                    showText(it.error)
                }
            }
        }
    }

    private fun toDetail(data: ResponsePredict) {

        val fragmentManager = parentFragmentManager
        val detailFragment = DetailRecordPatientFragment()
        val bundle = Bundle()
        bundle.putParcelable("predict", data)
        detailFragment.arguments = bundle
        fragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main, detailFragment, DetailRecordPatientFragment::class.java.simpleName)
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }


    private fun searchSymptom() {
        binding.edtSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                list.clear()
                list.addAll(listSymptom)

                showRecyclerSymptom(
                    list.filter {
                        it.symptom!!.symptomName.contains(p0.toString(), ignoreCase = true)
                    } as ArrayList<InputSymptom>
                )
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }


    private fun getData(){
        recordPatientViewModel.getSymptom().observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    showloading(false)
                    setData(it.data)
                    binding.cvSymptom.visibility = View.VISIBLE
                }
                is Result.Loading -> {
                    binding.cvSymptom.visibility = View.GONE
                    showloading(true)
                }
                is Result.Error -> {
                    showloading(false)
                    binding.cvSymptom.visibility = View.VISIBLE
                    showText(it.error)
                }
            }
        }
    }

    private fun setData(data: List<Symptom>) {
        data.forEach {
            listSymptom.add(
                InputSymptom(
                    false,
                    it
                )
            )
        }
        showRecyclerSymptom(listSymptom)
    }

    private fun showRecyclerSymptom(list: ArrayList<InputSymptom>) {
        binding.rvSymptom.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvSymptom.setHasFixedSize(true)
        val adapter = DiagnosisAdapter(list)
        binding.rvSymptom.adapter = adapter

        adapter.setOnItemClickCallback(object: DiagnosisAdapter.OnItemClickCallback {
            override fun onItemClicked(data: InputSymptom) {
                val foundIndex = listSymptom.indexOf(data)
                listSymptom[foundIndex].isChecked = !listSymptom[foundIndex].isChecked

                if(listSymptom[foundIndex].isChecked) {
                    jsonObjectOfSymptom.addProperty(listSymptom[foundIndex].symptom!!.symptomName, listSymptom[foundIndex].symptom!!.weight)
                }else {
                    jsonObjectOfSymptom.remove(listSymptom[foundIndex].symptom!!.symptomName)
                }
            }

        })

    }

    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }

    private fun showloading(state: Boolean) {
        if(state) {
            binding.progressBar.visibility = View.VISIBLE
        }else {
            binding.progressBar.visibility = View.GONE
        }
    }

}