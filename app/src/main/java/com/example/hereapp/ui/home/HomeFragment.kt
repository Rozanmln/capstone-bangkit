package com.example.hereapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hereapp.R
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.databinding.FragmentHomeBinding
import com.example.hereapp.ui.medical.hospital.RecordHospitalFragment
import com.example.hereapp.ui.medical.patient.list.ListPatientRecordFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var userPreferences: UserPreferences
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPreferences = UserPreferences(requireContext())

        welcomeMessage(userPreferences.getPref().name!!)
        binding.btnToList.setOnClickListener {
            if(userPreferences.getPref().role == 1) {
                btnToList()
            }else {
                toMedical()
            }
        }
    }

    private fun toMedical() {
        val fragmentManager = parentFragmentManager
        val recordHospitalFragment = RecordHospitalFragment()

        fragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            replace(R.id.nav_host_fragment_activity_main, recordHospitalFragment, RecordHospitalFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }

    private fun btnToList() {
        val fragmentManager = parentFragmentManager
        val listPatientRecordFragment = ListPatientRecordFragment()
        fragmentManager.popBackStack()
        fragmentManager.beginTransaction().apply {
            add(R.id.nav_host_fragment_activity_main, listPatientRecordFragment, ListPatientRecordFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }

    private fun welcomeMessage(name: String) {
        binding.tvWelcomeName.text = String.format(resources.getString(R.string.welcome_message), name)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}