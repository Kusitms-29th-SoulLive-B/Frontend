package com.example.soullive.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soullive.R

class HomeKeywordModelAdapter(private var models: List<ModelSelected>)
    : RecyclerView.Adapter<HomeKeywordModelAdapter.HomKeywordModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomKeywordModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_home_keyword_model, parent, false)
        return HomKeywordModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomKeywordModelViewHolder, position: Int) {
        val model = models[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    // 데이터 업데이트 메서드
    fun updateData(newModels: List<ModelSelected>) {
        models = newModels
        notifyDataSetChanged()
    }

    inner class HomKeywordModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelImage: ImageView = itemView.findViewById(R.id.model_img)
        private val modelName: TextView = itemView.findViewById(R.id.model_name)
        private val companyName: TextView = itemView.findViewById(R.id.company_name)
        private val title: TextView = itemView.findViewById(R.id.title)

        init {
            itemView.setOnClickListener {
                val clickedModel = models[adapterPosition]
                val modelId = clickedModel.modelId // 클릭된 모델의 Id를 가져옴
                val intent = Intent(itemView.context, ModelDetailActivity::class.java)
                intent.putExtra("model_id", modelId)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(modelList: ModelSelected) {
            modelName.text = modelList.name
            companyName.text = modelList.company
            title.text = modelList.keyword2

            Glide.with(itemView.context)
                .load(modelList.image)
                .placeholder(R.drawable.img_model_sample) // 플레이스홀더 이미지 리소스
                .error(R.drawable.img_model_sample) // 에러 이미지 리소스
                .into(modelImage)
        }

    }
}