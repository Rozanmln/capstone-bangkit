package com.example.hereapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.MainActivity
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.model.LoginRequest
import com.example.hereapp.data.model.UserSession
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
        showLoading(false)

        isLogin()
    }

    private fun isLogin() {
        if(userPreferences.getPref().isLogin == true) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun showLoading(state: Boolean) {
        if(state){
            binding.progressBar.visibility = View.VISIBLE
        }else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun btnLogin() {
        binding.btnLogin.setOnClickListener {
            val tvUsername = binding.edtUsername.text.toString()
            val tvPassword = binding.edtPassword.text.toString()
            val role = binding.rgRole.checkedRadioButtonId

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
        loginViewModel.postLoginHospital(request).observe(this) {
            when(it) {
                is Result.Success -> {
                    showText(it.data.message)
                    showLoading(false)
                    if(it.data.message == "Login successful") {
                        userPreferences.setPref(
                           UserSession(
                               true,
                               request.username,
                               it.data.token,
                               2
                           )
                        )
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }

                }
                is Result.Loading -> {
                    showLoading(true)
                }
                is Result.Error -> {
                    showText(it.error)
                    showLoading(false)
                }
            }
        }
    }
    private fun postPatient(request: LoginRequest) {
        loginViewModel.postLoginPatient(request).observe(this) {
            when(it) {
                is Result.Success -> {
                    showLoading(false)
                    showText(it.data.message)
                    if(it.data.message == "Login successful") {
                        userPreferences.setPref(
                            UserSession(
                                true,
                                request.username,
                                it.data.token,
                                1
                            )
                        )
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }
                }
                is Result.Loading -> {
                    showLoading(true)
                }
                is Result.Error -> {
                    showText(it.error)
                    showLoading(false)
                }
            }
        }
    }

    private fun showText(text: String) {
        Toast.makeText(this@LoginActivity, text, Toast.LENGTH_SHORT).show()
    }
    private fun toRegister() {
        binding.toRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()
        }
    }
}