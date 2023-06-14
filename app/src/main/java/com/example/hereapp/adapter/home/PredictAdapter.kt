package com.example.hereapp.adapter.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.data.model.Predict
import com.example.hereapp.databinding.ItemRiwayatHospitalBinding

class PredictAdapter(private val list: ArrayList<Predict>): RecyclerView.Adapter<PredictAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Predict)
    }

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }
    class ViewHolder(private val item: ItemRiwayatHospitalBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: Predict) {

            val pattern = "\"(.*?)\"".toRegex()
            val matches = pattern.findAll(data.symptoms)

            var symptom = ""
            for (match in matches) {
                val extractedString = match.groupValues[1]
                symptom += extractedString + ", "
            }
            item.tvDiagnosis.text = symptom
            item.patientNik.visibility = View.GONE
            item.patientName.visibility = View.GONE
            item.tvDate.visibility = View.GONE
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ViewHolder {
        val view = ItemRiwayatHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data)
        }
    }

    override fun getItemCount(): Int = list.size

}