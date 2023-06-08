package com.example.hereapp.adapter.patient

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.databinding.ItemSearchSymptonBinding


class DiagnosisSearchAdapter(private val list: ArrayList<Symptom>): RecyclerView.Adapter<DiagnosisSearchAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Symptom)
    }

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }
    class ViewHolder(private val item: ItemSearchSymptonBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: Symptom) {
            item.tvSymptom.text = data.symptomName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSearchSymptonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data)
        }
    }
}