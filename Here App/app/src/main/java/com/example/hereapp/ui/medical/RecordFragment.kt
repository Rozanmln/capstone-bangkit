package com.example.hereapp.ui.medical

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hereapp.R
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.databinding.FragmentRecordBinding
import com.example.hereapp.ui.medical.hospital.DetailRecordHospitalFragment
import com.example.hereapp.ui.medical.hospital.RecordHospitalFragment
import com.example.hereapp.ui.medical.patient.AddRecordPatientFragment

class RecordFragment : Fragment() {
    private lateinit var userPreferences: UserPreferences
    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecordBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userPreferences = UserPreferences(requireActivity())
        val fragmentManager = parentFragmentManager
        val hospital  = RecordHospitalFragment()
        val patient = AddRecordPatientFragment()

        fragmentManager.beginTransaction().apply {
            when(userPreferences.getPref().role) {
                1 -> replace(R.id.nav_host_fragment_activity_main, patient, AddRecordPatientFragment::class.java.simpleName)
                2 -> replace(R.id.nav_host_fragment_activity_main, hospital, RecordHospitalFragment::class.java.simpleName)
            }
            addToBackStack(null)
            commit()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}