package com.example.hereapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.R
import com.example.hereapp.adapter.home.ArticleAdapter
import com.example.hereapp.adapter.home.MainAdapter
import com.example.hereapp.data.model.DataFeature
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.databinding.FragmentHomeBinding
import com.example.hereapp.dummy.DataDummy
import com.example.hereapp.ui.medical.patient.list.ListFragment
import com.example.hereapp.ui.medical.patient.list.ListPatientRecordFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var userPreferences: UserPreferences
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<DataFeature>()

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

        btnToList()
    }

    private fun btnToList() {
        binding.btnToList.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val listPatientRecordFragment = ListPatientRecordFragment()
            fragmentManager.popBackStack()
            fragmentManager.beginTransaction().apply {
                add(R.id.nav_host_fragment_activity_main, listPatientRecordFragment, ListPatientRecordFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

        }
    }

    private fun getDummyData(): List<String> = DataDummy.generateMainImage()
    private fun welcomeMessage(name: String) {
        binding.tvWelcomeName.text = String.format(resources.getString(R.string.welcome_message), name)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}