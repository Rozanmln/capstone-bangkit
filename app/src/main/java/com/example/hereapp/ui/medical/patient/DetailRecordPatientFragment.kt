package com.example.hereapp.ui.medical.patient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hereapp.data.model.ResponsePredict
import com.example.hereapp.databinding.FragmentDetailRecordPatientBinding


class DetailRecordPatientFragment : Fragment() {
    private var _binding: FragmentDetailRecordPatientBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailRecordPatientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)
        getData()
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if(state) binding.progressBar.visibility = View.VISIBLE
        else binding.progressBar.visibility = View.GONE
    }

    private fun getData() {
        val data = arguments?.getParcelable<ResponsePredict>("predict")
        if(data != null) {
            setData(data)
        }
    }

    private fun setData(data: ResponsePredict) {
        binding.tvKeluhan.text = data.objectWithId!!.disease.toString()
        binding.tvDiagnosis.text = data.objectWithId.description.toString()
        binding.tvSaran.text = data.objectWithId.precaution.toString()
    }
}