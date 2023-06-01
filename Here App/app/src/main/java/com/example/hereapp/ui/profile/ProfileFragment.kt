package com.example.hereapp.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        val notificationsViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userPreferences = UserPreferences(requireActivity())

        //logout coba2 aja, tapi activitynya ga bisa di finish, jadi masih bisa balik ke activity sebelumnya
        binding.btnLogout.setOnClickListener {
            userPreferences.clearSession()
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}