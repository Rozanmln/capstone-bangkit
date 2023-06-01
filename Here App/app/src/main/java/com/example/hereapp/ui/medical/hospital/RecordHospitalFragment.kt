package com.example.hereapp.ui.medical.hospital

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hereapp.R
import com.example.hereapp.adapter.medical.RecordHospitalAdapter
import com.example.hereapp.data.model.RecordHospital
import com.example.hereapp.databinding.FragmentRecordHospitalBinding
import com.example.hereapp.dummy.DataDummy


class RecordHospitalFragment : Fragment() {
    private var _binding: FragmentRecordHospitalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecordHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRecyclerView()
        addMedicalRecord()
    }

    private fun addMedicalRecord() {
        binding.fabAdd.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val addMedicalRecordHospital = AddMedicalRecordHospital()

            fragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_activity_main, addMedicalRecordHospital, AddMedicalRecordHospital::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun showRecyclerView() {
        val data = DataDummy.generateRecordHospitalDummy()
        binding.rvRiwayatHospital.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvRiwayatHospital.setHasFixedSize(true)
        binding.rvRiwayatHospital.adapter = RecordHospitalAdapter(data as ArrayList<RecordHospital>)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}