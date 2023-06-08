package com.example.hereapp.adapter.patient

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.R
import com.example.hereapp.data.model.Symptom
import com.example.hereapp.databinding.ItemSymptomBinding

class AddDiagnosisAdapter(private val list: ArrayList<Symptom>): RecyclerView.Adapter<AddDiagnosisAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    interface OnItemClickCallback {
        fun onItemClicked(data: Symptom)
    }
    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }
    class ViewHolder(val item: ItemSymptomBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: Symptom, position: Int) {
            item.tvSymptom.text = itemView.context.getString(R.string.keluhan, position + 1, data.symptomName)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSymptomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data, position)

        holder.item.ivSymptom.setOnClickListener {
            onItemClickCallback.onItemClicked(data)
        }
    }
}