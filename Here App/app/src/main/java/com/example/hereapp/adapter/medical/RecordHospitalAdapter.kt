package com.example.hereapp.adapter.medical

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hereapp.R
import com.example.hereapp.data.model.RecordHospital
import com.example.hereapp.databinding.ItemRiwayatHospitalBinding
import com.example.hereapp.ui.medical.hospital.DetailRecordHospitalFragment


class RecordHospitalAdapter(private val list: ArrayList<RecordHospital>): RecyclerView.Adapter<RecordHospitalAdapter.ViewHolder>() {

    class ViewHolder(private val item: ItemRiwayatHospitalBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: RecordHospital) {
            item.tvDate.text = data.date
            item.patientName.text = data.name
            item.patientNik.text = data.nik

            itemView.setOnClickListener {
                val detailFragment = DetailRecordHospitalFragment()
                val fragmentManager =(itemView.context as FragmentActivity).supportFragmentManager

                fragmentManager.beginTransaction().apply {
                    replace(R.id.nav_host_fragment_activity_main, detailFragment)
                    addToBackStack(null)
                    commit()
                }
            }
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
    }

    override fun getItemCount(): Int = list.size
}