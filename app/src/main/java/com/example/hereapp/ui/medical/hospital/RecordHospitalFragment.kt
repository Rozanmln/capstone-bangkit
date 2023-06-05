package com.example.hereapp.ui.medical.hospital

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
import com.example.hereapp.adapter.medical.RecordHospitalAdapter
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.databinding.FragmentRecordHospitalBinding
import com.example.hereapp.ui.medical.hospital.add.AddMedicalRecordHospitalFragment
import com.example.hereapp.utils.Result
import java.sql.Array


class RecordHospitalFragment : Fragment() {
    private val list = ArrayList<MedicalRecord>()
    private lateinit var factory: ViewModelFactory
    private lateinit var recordHospitalViewModel: RecordHospitalViewModel
    private var _binding: FragmentRecordHospitalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecordHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = ViewModelFactory.getInstance(requireActivity())
        recordHospitalViewModel = ViewModelProvider(this, factory)[RecordHospitalViewModel::class.java]

        showRecyclerView()
        addMedicalRecord()

    }

    private fun showLoading(state: Boolean) {
        if(state) binding.progressBar.visibility = View.VISIBLE
        else binding.progressBar.visibility = View.GONE
    }

    private fun searchUser() {
        binding.edtSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val newList = list.filter {
                    it.patientName.contains(p0!!, ignoreCase = true)
                }
                val adapter = RecordHospitalAdapter(newList as ArrayList<MedicalRecord>)
                binding.rvRiwayatHospital.adapter = adapter
                toDetail(adapter)

            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun addMedicalRecord() {
        binding.fabAdd.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val addMedicalRecordHospital = AddMedicalRecordHospitalFragment()

            fragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_activity_main, addMedicalRecordHospital, AddMedicalRecordHospitalFragment::class.java.simpleName)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun showRecyclerView() {
        getData()

        binding.rvRiwayatHospital.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvRiwayatHospital.setHasFixedSize(true)

    }

    private fun getData() {
        recordHospitalViewModel.getListMedicalRecordForHospital().observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                    showLoading(false)
                    list.clear()
                    list.addAll(it.data)
                    list.reverse()
                    val recordHospitalAdapter = RecordHospitalAdapter(list)
                    binding.rvRiwayatHospital.adapter = recordHospitalAdapter
                    toDetail(recordHospitalAdapter)
                    searchUser()
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
    }


    private fun showText(text: String) {
        Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
    }

    private fun toDetail(recordHospitalAdapter: RecordHospitalAdapter) {
        recordHospitalAdapter.setOnItemClickCallback(object: RecordHospitalAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MedicalRecord) {
                val fragmentManager = parentFragmentManager
                val detailRecordHospitalFragment = DetailRecordHospitalFragment()
                detailRecordHospitalFragment.mrid = data.mrid

                fragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_activity_main, detailRecordHospitalFragment, DetailRecordHospitalFragment::class.java.simpleName)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                    commit()
                }
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}