package com.example.hereapp.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hereapp.data.model.DataFeature
import com.example.hereapp.databinding.ItemFeatureBinding


class FeatureAdapter(private val list : ArrayList<DataFeature>): RecyclerView.Adapter<FeatureAdapter.ViewHolder>() {

    class ViewHolder(private val item: ItemFeatureBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: DataFeature) {
            Glide.with(itemView.context)
                .load(data.imageUrl)
                .centerCrop()
                .into(item.imageFeature)
            item.tvFeature.text = data.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureAdapter.ViewHolder {
        val view = ItemFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FeatureAdapter.ViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

}