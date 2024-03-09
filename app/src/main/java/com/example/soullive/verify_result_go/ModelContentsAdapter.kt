package com.example.soullive.verify_result_go

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.soullive.R

class ModelContentsAdapter(private var contents: List<Int>)
    : RecyclerView.Adapter<ModelContentsAdapter.ModelContentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelContentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_model_contents, parent, false)
        return ModelContentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelContentsViewHolder, position: Int) {
        val content = contents[position]
        holder.bind(content)
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    // 데이터 업데이트 메서드
    fun updateData(newContents: List<Int>) {
        contents = newContents
        notifyDataSetChanged()
    }

    inner class ModelContentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val model: ImageView = itemView.findViewById(R.id.contents_img)

        init {
            itemView.setOnClickListener {
            }
        }

        fun bind(ContentList: Int) {
            model.setImageResource(ContentList)
        }
    }
}