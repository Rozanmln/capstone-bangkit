package com.example.hereapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hereapp.MainActivity
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.databinding.FragmentProfileBinding
import com.example.hereapp.ui.login.LoginActivity

class ProfileFragment : Fragment() {
    private lateinit var userPreferences: UserPreferences
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

        binding.btnLogout.setOnClickListener {
            userPreferences.clearSession()
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            if(requireActivity() is MainActivity) {
                requireActivity().finish()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}