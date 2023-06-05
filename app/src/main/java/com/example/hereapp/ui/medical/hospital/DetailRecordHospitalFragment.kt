package com.example.hereapp.ui.medical.hospital

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.adapter.medical.RecordHospitalAdapter
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.databinding.FragmentDetailRecordHospitalBinding
import com.example.hereapp.utils.Result


class DetailRecordHospitalFragment : Fragment() {
    var mrid: String? = null
    private var _binding: FragmentDetailRecordHospitalBinding? = null
    private lateinit var factory: ViewModelFactory
    private lateinit var recordHospitalViewModel: RecordHospitalViewModel
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailRecordHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireActivity())
        recordHospitalViewModel = ViewModelProvider(this, factory)[RecordHospitalViewModel::class.java]
        setDetail()
    }

    private fun setDetail() {
        recordHospitalViewModel.getDetail(mrid!!).observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    bindData(it.data)
                }
                is Result.Loading -> {

                }
                is Result.Error -> {
                    showText(it.error)
                }
            }
        }
    }

    private fun bindData(data: MedicalRecordDetail) {
        binding.apply {
            tvDate.text = data.createdAt
            tvKeluhan.text = data.symptom
            tvDiagnosis.text = data.diagnostic_results
            tvSaran.text = data.doctor_recommendation
        }
    }

    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}