package com.example.hereapp.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hereapp.R
import com.example.hereapp.ViewModelFactory
import com.example.hereapp.data.model.RegisterHospitalRequest
import com.example.hereapp.data.model.RegisterPatientRequest
import com.example.hereapp.databinding.ActivityRegisterBinding
import com.example.hereapp.ui.login.LoginActivity
import com.example.hereapp.utils.Result

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var factory: ViewModelFactory
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        factory = ViewModelFactory.getInstance(this)
        registerViewModel = ViewModelProvider(this, factory)[RegisterViewModel::class.java]

        roleAdjustment()
        toLogin()
        btnRegister()
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if(state) {
            binding.progressBar.visibility = View.VISIBLE
        }else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun btnRegister() {
        binding.btnRegister.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            when(binding.rgRole.checkedRadioButtonId) {
                R.id.rb_hospital -> {
                    val address = binding.edtAddress.text.toString()
                    val request = RegisterHospitalRequest(
                        username,
                        email,
                        password,
                        address)
                    postHospital(request)
                }

                R.id.rb_patient -> {
                    val NIK = binding.edtNik.text.toString()
                    val address = binding.edtAddress.text.toString()
                    val request = RegisterPatientRequest(
                        username,
                        email,
                        password,
                        NIK,
                        address
                    )
                    postPatient(request)
                }
            }
        }
    }

    private fun postPatient(request: RegisterPatientRequest) {
        registerViewModel.postRegisterPatient(request).observe(this) {
            when(it) {
                is Result.Success -> {
                    showText(it.data.msg)
                    showLoading(false)
                    if(it.data.msg == "Register Berhasil") {
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    }
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

    private fun postHospital(request: RegisterHospitalRequest) {
      registerViewModel.postRegisterHospital(request).observe(this) {
          when(it) {
              is Result.Success -> {
                  showText(it.data.msg)
                  showLoading(false)
                  if(it.data.msg == "Register Berhasil") {
                      startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
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

    private fun toLogin() {
        binding.toLogin.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }
    }

    private fun roleAdjustment() {
        binding.tiNik.visibility = View.GONE
        binding.tiAddress.visibility = View.GONE

        binding.rgRole.setOnCheckedChangeListener { _, checkedId ->
           when(checkedId) {
               binding.rbHospital.id -> {
                   binding.tiAddress.visibility = View.VISIBLE
                   binding.tiNik.visibility = View.GONE
               }
               binding.rbPatient.id -> {
                   binding.tiNik.visibility = View.VISIBLE
                   binding.tiAddress.visibility = View.VISIBLE
               }
           }
        }
    }
    private fun showText(text: String) {
        Toast.makeText(this@RegisterActivity, text, Toast.LENGTH_SHORT).show()
    }
}