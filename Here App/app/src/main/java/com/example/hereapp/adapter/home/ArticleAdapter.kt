package com.example.hereapp.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hereapp.data.model.DataArticle
import com.example.hereapp.databinding.ItemArticleBinding

class ArticleAdapter(private val dataArticle: ArrayList<DataArticle>): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(private val item: ItemArticleBinding): RecyclerView.ViewHolder(item.root) {
        fun bind(data: DataArticle) {
            Glide.with(itemView.context)
                .load(data.imageUrl)
                .centerCrop()
                .into(item.ivArticle)

            item.tvDescription.text = data.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataArticle.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataArticle[position]
        holder.bind(data)
    }
}