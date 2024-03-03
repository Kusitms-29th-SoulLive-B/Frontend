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

class HomeSelectedModelAdapter(private var models: List<Model>)
    : RecyclerView.Adapter<HomeSelectedModelAdapter.HomeSelectedModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSelectedModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_home_selected_model, parent, false)
        return HomeSelectedModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeSelectedModelViewHolder, position: Int) {
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

    inner class HomeSelectedModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelImage: ImageView = itemView.findViewById(R.id.model_img)
        private val modelName: TextView = itemView.findViewById(R.id.model_name)
        private val modelJob: TextView = itemView.findViewById(R.id.model_job)
        private val companyImage: ImageView = itemView.findViewById(R.id.company_img)
        private val companyName: TextView = itemView.findViewById(R.id.company_name)
        private val keyword1: TextView = itemView.findViewById(R.id.keyword1_txt)
        private val keyword2: TextView = itemView.findViewById(R.id.keyword2_txt)
        private val heartImage: ImageView = itemView.findViewById(R.id.heart_ic)

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

            Glide.with(itemView.context)
                .load(modelList.image)
                .placeholder(R.drawable.img_model_sample) // 플레이스홀더 이미지 리소스
                .error(R.drawable.img_model_sample) // 에러 이미지 리소스
                .into(modelImage)
        }

    }
}