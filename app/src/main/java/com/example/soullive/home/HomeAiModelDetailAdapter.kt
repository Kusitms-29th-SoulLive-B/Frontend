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

class HomeAiModelDetailAdapter(private var models: List<ModelAi>, private val isGridMode: Boolean)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_LIST = 1
    private val VIEW_TYPE_GRID = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_LIST) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_home_ai_list_model, parent, false)
            ListViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_home_ai_gallery_model, parent, false)
            GridViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = models[position]
        if (holder is ListViewHolder) {
            holder.bind(model)
        } else if (holder is GridViewHolder) {
            holder.bind(model)
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isGridMode) VIEW_TYPE_GRID else VIEW_TYPE_LIST
    }

    // 데이터 업데이트 메서드
    fun updateData(newModels: List<ModelAi>) {
        models = newModels
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelImage: ImageView = itemView.findViewById(R.id.model_img)
        private val modelName: TextView = itemView.findViewById(R.id.model_name)
        private val modelJob: TextView = itemView.findViewById(R.id.model_job)
        private val age: TextView = itemView.findViewById(R.id.like_age)
        private val gender: TextView = itemView.findViewById(R.id.like_gender)
        private val keyword1: TextView = itemView.findViewById(R.id.keyword1)
        private val keyword2: TextView = itemView.findViewById(R.id.keyword1)

        init {
            itemView.setOnClickListener {
                val clickedModel = models[adapterPosition]
                val modelId = clickedModel.modelId // 클릭된 모델의 Id를 가져옴
                val intent = Intent(itemView.context, ModelDetailActivity::class.java)
                intent.putExtra("model_id", modelId)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(modelList: ModelAi) {
            modelName.text = modelList.name
            modelJob.text = modelList.job
            age.text = modelList.age
            gender.text = modelList.gender
            keyword1.text = modelList.keyword1
            keyword2.text = modelList.keyword2

            Glide.with(itemView.context)
                .load(modelList.image)
                .placeholder(R.drawable.img_model_sample) // 플레이스홀더 이미지 리소스
                .error(R.drawable.img_model_sample) // 에러 이미지 리소스
                .into(modelImage)
        }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelImage: ImageView = itemView.findViewById(R.id.model_img)
        private val modelName: TextView = itemView.findViewById(R.id.model_name)
        private val modelJob: TextView = itemView.findViewById(R.id.model_job)
        private val keyword1: TextView = itemView.findViewById(R.id.keyword1_txt)
        private val keyword2: TextView = itemView.findViewById(R.id.keyword1_txt)

        init {
            itemView.setOnClickListener {
                val clickedModel = models[adapterPosition]
                val modelId = clickedModel.modelId // 클릭된 모델의 Id를 가져옴
                val intent = Intent(itemView.context, ModelDetailActivity::class.java)
                intent.putExtra("model_id", modelId)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(modelList: ModelAi) {
            modelName.text = modelList.name
            modelJob.text = modelList.job
            keyword1.text = modelList.keyword1
            keyword2.text = modelList.keyword2

            Glide.with(itemView.context)
                .load(modelList.image)
                .placeholder(R.drawable.img_model_sample) // 플레이스홀더 이미지 리소스
                .error(R.drawable.img_model_sample) // 에러 이미지 리소스
                .into(modelImage)
        }
    }
}