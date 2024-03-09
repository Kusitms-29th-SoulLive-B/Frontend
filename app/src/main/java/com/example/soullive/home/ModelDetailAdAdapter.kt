package com.example.soullive.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.soullive.R

class ModelDetailAdAdapter(private var ads: List<Ad>)
    : RecyclerView.Adapter<ModelDetailAdAdapter.ModelDetailAdViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelDetailAdViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_model_recent_ad, parent, false)
        return ModelDetailAdViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelDetailAdViewHolder, position: Int) {
        val ad = ads[position]
        holder.bind(ad)
    }

    override fun getItemCount(): Int {
        return ads.size
    }

    // 데이터 업데이트 메서드
    fun updateData(newAds: List<Ad>) {
        ads = newAds
        notifyDataSetChanged()
    }

    inner class ModelDetailAdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val model: ImageView = itemView.findViewById(R.id.model_img)
        private val logo: ImageView = itemView.findViewById(R.id.ad_logo)

        init {
            itemView.setOnClickListener {
            }
        }

        fun bind(AdList: Ad) {
            model.setImageResource(AdList.modelImage)
            logo.setImageResource(AdList.logo)
        }
    }
}