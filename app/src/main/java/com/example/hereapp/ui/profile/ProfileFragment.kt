package com.example.hereapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.MainActivity
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.databinding.FragmentProfileBinding
import com.example.hereapp.ui.login.LoginActivity
import com.example.hereapp.utils.Result

class ProfileFragment : Fragment() {
    private lateinit var userPreferences: UserPreferences
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var factory: ViewModelFactory
    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userPreferences = UserPreferences(requireActivity())
        factory = ViewModelFactory.getInstance(requireActivity())
        profileViewModel = ViewModelProvider(requireActivity(), factory)[ProfileViewModel::class.java]

        setProfile(profileViewModel)

        profileFeature()
    }

    private fun profileFeature() {
        btnLogout()
    }

    private fun btnLogout() {
        binding.btnLogout.setOnClickListener {
            userPreferences.clearSession()
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }

    private fun setProfile(profileViewModel: ProfileViewModel) {
        profileViewModel.getInfoHospitalSelf().observe(requireActivity()) {
            when(it) {
                is Result.Success -> {
                }
                is Result.Loading -> {
                }
                is Result.Error -> {
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}