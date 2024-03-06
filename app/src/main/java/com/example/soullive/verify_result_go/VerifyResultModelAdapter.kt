package com.example.soullive.verify_result_go

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.soullive.R
import com.example.soullive.home.ModelResult

class VerifyResultModelAdapter(private var models: List<ModelResult>,
                               private val listener: ModelItemClickListener)
    : RecyclerView.Adapter<VerifyResultModelAdapter.VerifyResultModelViewHolder>() {

    private var selectedItemPosition: Int = RecyclerView.NO_POSITION

    interface ModelItemClickListener {
        fun onModelItemClick(model: ModelResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerifyResultModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_model_result, parent, false)
        return VerifyResultModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerifyResultModelViewHolder, position: Int) {
        val model = models[position]
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    // 데이터 업데이트 메서드
    fun updateData(newModels: List<ModelResult>) {
        models = newModels
        notifyDataSetChanged()
    }

    fun setSelectedPosition(position: Int) {
        selectedItemPosition = position
        notifyDataSetChanged() // 선택이 변경될 때마다 UI를 갱신합니다.
    }

    inner class VerifyResultModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val model: ImageView = itemView.findViewById(R.id.model_img)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedModel = models[position]
                    listener.onModelItemClick(clickedModel)
                }
            }
        }

        fun bind(ModelList: ModelResult, position: Int) {
            model.setImageResource(ModelList.image)

            // 선택된 아이템인 경우 배경 이미지뷰를 표시하고 아니면 숨김
            if (position == selectedItemPosition) {
                itemView.findViewById<View>(R.id.bg_model).visibility = View.VISIBLE
            } else {
                itemView.findViewById<View>(R.id.bg_model).visibility = View.GONE
            }

            itemView.setOnClickListener {
                if (position != RecyclerView.NO_POSITION) {
                    selectedItemPosition = position
                    notifyDataSetChanged() // 아이템들을 업데이트하여 배경 이미지뷰를 업데이트
                    val clickedModel = models[position]
                    listener.onModelItemClick(clickedModel)
                }
            }
        }
    }
}