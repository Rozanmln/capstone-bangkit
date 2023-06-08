package com.example.hereapp.adapter.patient

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.databinding.ItemSymptomBinding

class AddDiagnosisAdapter(private val list: ArrayList<Symptom>): RecyclerView.Adapter<AddDiagnosisAdapter.ViewHolder>() {
    class ViewHolder(private val item: ItemSymptomBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: Symptom) {
            item.tvCounter.text = data.id.toString()
            item.tvSymptom.text = data.symptomName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSymptomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }
}