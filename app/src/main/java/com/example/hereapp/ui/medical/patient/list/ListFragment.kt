package com.example.hereapp.ui.medical.patient.list

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.adapter.home.PredictAdapter
import com.example.hereapp.adapter.medical.RecordHospitalAdapter
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.Predict
import com.example.hereapp.databinding.FragmentListBinding
import com.example.hereapp.ui.home.HomeFragment
import com.example.hereapp.ui.medical.hospital.DetailRecordHospitalFragment
import com.example.hereapp.ui.medical.patient.PatientViewModel
import com.example.hereapp.utils.Result

class ListFragment : Fragment() {
    private val list = ArrayList<MedicalRecord>()
    private val listPredict = ArrayList<Predict>()
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var factory: ViewModelFactory
    private lateinit var patientViewModel: PatientViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireActivity())
        patientViewModel = ViewModelProvider(this, factory)[PatientViewModel::class.java]

        showRecyclerView()

    }

    private fun showRecyclerView() {
        getData()
        binding.rvRecord.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvRecord.setHasFixedSize(true)
    }

    private fun getData() {
        when(arguments?.getInt(ARG_SECTION_NUMBER, 0)) {
            1 ->  {
                patientViewModel.getListMedRecordForPatient().observe(requireActivity()) {
                    when(it) {
                        is Result.Success -> {
                            list.clear()
                            list.addAll(it.data)
                            list.reverse()
                            val recordHospitalAdapter = RecordHospitalAdapter(list)
                            binding.rvRecord.adapter = recordHospitalAdapter
                            toDetail(recordHospitalAdapter = recordHospitalAdapter)
                        }
                        is Result.Loading -> {
                        }
                        is Result.Error -> {
                        }
                    }
                }
            }
            2 -> {
                patientViewModel.getListPredict().observe(requireActivity()) {
                    when(it) {
                        is Result.Success -> {
                            listPredict.clear()
                            listPredict.addAll(it.data)
                            listPredict.reverse()
                            val predictAdapter = PredictAdapter(listPredict)
                            binding.rvRecord.adapter = predictAdapter
                            toDetail(predictAdapter = predictAdapter)
                        }
                        is Result.Loading -> {
                        }
                        is Result.Error -> {
                        }
                    }
                }
            }
        }
    }

    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }

    private fun toDetail(recordHospitalAdapter: RecordHospitalAdapter? = null, predictAdapter: PredictAdapter? = null) {

        if(recordHospitalAdapter != null) {
            recordHospitalAdapter.setOnItemClickCallback(object: RecordHospitalAdapter.OnItemClickCallback {
                override fun onItemClicked(data: MedicalRecord) {
                    val intent = Intent(requireActivity(), DetailListPatientActivity()::class.java)
                    intent.putExtra(DetailListPatientActivity.MRID, data.mrid)
                    startActivity(intent)
                }

            })
        }
        else predictAdapter?.setOnItemClickCallback(object: PredictAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Predict) {
                val intent = Intent(requireActivity(), DetailListPatientActivity()::class.java)
                intent.putExtra(DetailListPatientActivity.PRID, data.prid)
                startActivity(intent)
            }

        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {
        const val ARG_SECTION_NUMBER = "ARG_SECTION_NUMBER"
    }
}