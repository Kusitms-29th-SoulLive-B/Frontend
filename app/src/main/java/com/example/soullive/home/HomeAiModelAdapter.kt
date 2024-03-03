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

class HomeAiModelAdapter(private var models: List<Model>)
    : RecyclerView.Adapter<HomeAiModelAdapter.HomeAiModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAiModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_home_ai_model, parent, false)
        return HomeAiModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAiModelViewHolder, position: Int) {
        val model = models[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    // 데이터 업데이트 메서드
    fun updateData(newModels: List<Model>) {
        models = newModels
        notifyDataSetChanged()
    }

    inner class HomeAiModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelImage: ImageView = itemView.findViewById(R.id.model_img)
        private val modelName: TextView = itemView.findViewById(R.id.model_name)
        private val modelType: TextView = itemView.findViewById(R.id.model_type)

        init {
            itemView.setOnClickListener {
                val clickedModel = models[adapterPosition]
                val modelId = clickedModel.modelId // 클릭된 모델의 Id를 가져옴
                val intent = Intent(itemView.context, ModelDetailActivity::class.java)
                intent.putExtra("model_id", modelId)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(modelList: Model) {
            modelName.text = modelList.name
            modelType.text = modelList.job

            Glide.with(itemView.context)
                .load(modelList.image)
                .placeholder(R.drawable.img_model_sample) // 플레이스홀더 이미지 리소스
                .error(R.drawable.img_model_sample) // 에러 이미지 리소스
                .into(modelImage)
        }
    }
}