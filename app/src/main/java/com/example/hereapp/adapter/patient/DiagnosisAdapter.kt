package com.example.hereapp.adapter.patient

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.data.model.InputSymptom
import com.example.hereapp.databinding.ItemSymptonBinding


class DiagnosisAdapter(private val list: ArrayList<InputSymptom>): RecyclerView.Adapter<DiagnosisAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: InputSymptom)
    }

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }
    class ViewHolder(val item: ItemSymptonBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: InputSymptom) {
            item.tvSymptom.text = data.symptom!!.symptomName
            item.cbSymptom.isChecked = data.isChecked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSymptonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)

        holder.item.cbSymptom.setOnCheckedChangeListener { _, _ ->
            onItemClickCallback.onItemClicked(data)
        }
    }
}