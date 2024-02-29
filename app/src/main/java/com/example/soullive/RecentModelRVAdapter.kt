package com.example.soullive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecentModelRVAdapter(private val context: Context, private val dataList : ArrayList<RecentModelItem>) : RecyclerView.Adapter<RecentModelRVAdapter.ItemViewHolder>() {

    var mPosition = RecyclerView.NO_POSITION

    fun getPosition(): Int {
        return mPosition
    }

    fun addItem(recentModel: RecentModelItem) {
        dataList.add(0, recentModel) // 항상 첫 번째 위치에 추가
        notifyItemInserted(0)
    }


    fun removeItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val modelName = itemView.findViewById<TextView>(R.id.recentModel_tv)

        fun bind(recentModel: RecentModelItem) {
            modelName.text = recentModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recentsearch, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            mPosition = position
            Toast.makeText(it.context, "아이템 클릭", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
