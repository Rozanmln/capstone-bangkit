package com.example.hereapp.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.hereapp.R
import com.example.hereapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        roleAdjustment()
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