package com.example.hereapp.ui.medical.hospital.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.model.MedicalRecordDetail
import com.example.hereapp.data.model.MedicalRecordRequest
import com.example.hereapp.databinding.FragmentAddMedicalRecordHospitalBinding
import com.example.hereapp.ui.medical.hospital.RecordHospitalFragment
import com.example.hereapp.utils.Result
import okhttp3.internal.cache2.Relay.Companion.edit


class AddMedicalRecordHospitalFragment : Fragment() {
    private lateinit var addMedicalRecordHospitalViewModel: AddMedicalRecordHospitalViewModel
    private lateinit var factory: ViewModelFactory
    private var _binding: FragmentAddMedicalRecordHospitalBinding? = null
    private var data: MedicalRecordDetail? = null
    private var isFromEdit = false
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddMedicalRecordHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireActivity())
        addMedicalRecordHospitalViewModel = ViewModelProvider(this, factory)[AddMedicalRecordHospitalViewModel::class.java]

        data = arguments?.getParcelable<MedicalRecordDetail>("data")
        if(data != null) {
            isFromEdit = true
            binding.apply {
                edName.setText(data!!.patientName)
                edNik.setText(data!!.NIK)
                edtKeluhan.setText(data!!.symptom)
                edtDiagnosis.setText(data!!.diagnostic_results)
                edtSaran.setText(data!!.doctor_recommendation)
            }
        }

        submit()
    }

    private fun submit() {
       binding.apply {
           btnSubmit.setOnClickListener {
               if(mustHasValue()) {
                   val request = MedicalRecordRequest(
                       edName.text.toString(),
                       edNik.text.toString(),
                       edtKeluhan.text.toString(),
                       edtDiagnosis.text.toString(),
                       edtSaran.text.toString()
                   )
                   if(isFromEdit) {
                       edit(request)
                   }else {
                       post(request)
                   }

               }else {
                   showText("No yeah")
               }
           }
       }
    }

    private fun edit(request: MedicalRecordRequest) {
        addMedicalRecordHospitalViewModel.patchEditMedicalRecord(request).observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    showText(it.data.msg)
                    backToListMedRecord()
                }
                is Result.Loading -> {}
                is Result.Error -> {
                    showText(it.error)
                }
            }
        }
    }

    private fun post(request: MedicalRecordRequest) {
        addMedicalRecordHospitalViewModel.postCreateMedicalRecord(request).observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    showText(it.data.msg)
                    backToListMedRecord()
                }
                is Result.Loading -> {}
                is Result.Error -> {
                    showText(it.error)
                }
            }
        }
    }

    private fun backToListMedRecord() {
        val fragmentManager = parentFragmentManager
        val recordHospital = RecordHospitalFragment()

        fragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main, recordHospital, RecordHospitalFragment::class.java.simpleName)
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }

    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }

    private fun mustHasValue(): Boolean {
        var isTrue = true
        binding.apply {
            if(edName.text.isEmpty()) {
                isTrue = false
                edName.error = "Lengkapi isi Form!"
            }
            if(edNik.text.isEmpty()) {
                isTrue = false
                edNik.error = "Lengkapi isi Form!"
            }
            if(edtKeluhan.text.isEmpty()) {
                isTrue = false
                edtKeluhan.error = "Lengkapi isi Form!"
            }
            if(edtDiagnosis.text.isEmpty()) {
                isTrue = false
                edtDiagnosis.error = "Lengkapi isi Form!"
            }
            if(edtSaran.text.isEmpty()) {
                isTrue = false
                edtSaran.error = "Lengkapi isi Form!"
            }
        }

        return isTrue
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}