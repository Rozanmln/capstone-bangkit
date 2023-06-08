package com.example.hereapp.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hereapp.databinding.ItemFeatureBinding
import com.example.hereapp.databinding.ItemMainImageBinding

class MainAdapter(private val list: List<String>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(private val item: ItemMainImageBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: String) {
            Glide.with(itemView.context)
                .load(data)
                .centerCrop()
                .into(item.ivItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMainImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = list[position]
        holder.bind(data)
    }
}