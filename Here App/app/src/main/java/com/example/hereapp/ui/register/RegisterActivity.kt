package com.example.hereapp.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hereapp.databinding.ActivityRegisterBinding
import com.example.hereapp.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        roleAdjustment()
        toLogin()
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
                   binding.tiAddress.visibility = View.GONE
               }
           }
        }
    }
}