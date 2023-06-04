package com.example.hereapp.adapter.medical

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.data.model.MedicalRecord
import com.example.hereapp.databinding.ItemRiwayatHospitalBinding


class RecordHospitalAdapter(private val list: ArrayList<MedicalRecord>): RecyclerView.Adapter<RecordHospitalAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: MedicalRecord)
    }

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }
    class ViewHolder(private val item: ItemRiwayatHospitalBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: MedicalRecord) {
            item.tvDate.text = data.createdAt
            item.patientName.text = data.patientName
            item.patientNik.text = data.NIK
            item.tvDiagnosis.text = data.diagnostic_results
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

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MedicalRecord>() {
            override fun areItemsTheSame(oldItem: MedicalRecord, newItem: MedicalRecord): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MedicalRecord,
                newItem: MedicalRecord
            ): Boolean {
                return oldItem.mrid == newItem.mrid
            }

        }
    }
}