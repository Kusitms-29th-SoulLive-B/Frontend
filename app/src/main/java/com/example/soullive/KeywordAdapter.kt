package com.example.soullive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KeywordAdapter(private var keywords: List<String>)
    : RecyclerView.Adapter<KeywordAdapter.KeywordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_keyword, parent, false)
        return KeywordViewHolder(view)
    }

    override fun onBindViewHolder(holder: KeywordViewHolder, position: Int) {
        val keyword =keywords[position]
        holder.bind(keyword)
    }

    override fun getItemCount(): Int {
        return keywords.size
    }

    // 데이터 업데이트 메서드
    fun updateData(newKeywords: List<String>) {
        keywords = newKeywords
        notifyDataSetChanged()
    }

    inner class KeywordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val keyword: TextView = itemView.findViewById(R.id.keyword)

        init {
            itemView.setOnClickListener {
            }
        }

        fun bind(keywordList: String) {
            keyword.text = keywordList
        }
    }
}