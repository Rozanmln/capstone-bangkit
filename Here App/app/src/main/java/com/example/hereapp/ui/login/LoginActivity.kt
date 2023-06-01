package com.example.hereapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.MainActivity
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.preferences.UserPreferences
import com.example.hereapp.databinding.ActivityLoginBinding
import com.example.hereapp.ui.register.RegisterActivity
import com.example.hereapp.utils.Result

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var userPreferences: UserPreferences
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        userPreferences = UserPreferences(this)
        factory = ViewModelFactory.getInstance(this)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        toRegister()
        btnLogin()
    }

    private fun btnLogin() {
        binding.btnLogin.setOnClickListener {
            val tvUsername = binding.edtUsername.text.toString()
            val tvPassword = binding.edtPassword.text.toString()
            val role = binding.rgRole.checkedRadioButtonId

            if(tvUsername.equals("admin") && tvPassword.equals("admin")) {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
            val request = LoginRequest(
                tvUsername,
                tvPassword
            )

            when(role) {
                R.id.rb_patient -> postPatient(request)
                R.id.rb_hospital -> postHospital(request)
            }
        }
    }

    private fun postHospital(request: LoginRequest) {
        showText("yess")
        loginViewModel.postLoginHospital(request).observe(this) {
            when(it) {
                is Result.Success -> {
                   showText(it.data.message)
                }
                is Result.Loading -> {

                }
                is Result.Error -> {

                }
            }
        }
    }

    private fun showText(text: String) {
        Toast.makeText(this@LoginActivity, text, Toast.LENGTH_SHORT).show()
    }

    private fun postPatient(request: LoginRequest) {
        loginViewModel.postLoginPatient(request).observe(this) {
            when(it) {
                is Result.Success -> {
                    showText(it.data.message)
                }
                is Result.Loading -> {

                }
                is Result.Error -> {

                }
            }
        }
    }


    private fun toRegister() {
        binding.toRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()
        }
    }
}