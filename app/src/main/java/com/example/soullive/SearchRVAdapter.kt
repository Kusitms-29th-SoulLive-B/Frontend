package com.example.soullive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.soullive.databinding.ItemFavoritemodelBinding

class SearchRVAdapter(val modelList : MutableList<FavoriteModelItem>) : RecyclerView.Adapter<SearchRVAdapter.SearchViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchRVAdapter.SearchViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_favoritemodel, parent, false)
        return SearchViewHolder(v)
    }

    override fun onBindViewHolder(holder: SearchRVAdapter.SearchViewHolder, position: Int) {

        holder.bindItems(modelList[position])
    }

    override fun getItemCount(): Int {

        return modelList.count()
    }

    //ViewHolder: RecyclerView에서 각 아이템의 뷰를 보유하는 이너클래스
    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // bindItems: ViewHolder에 데이터를 바인딩하는 함수
        fun bindItems(modelList: FavoriteModelItem){

            //// XML에서 정의한 뷰들을 아이디를 이용해 가져오기
            val model = itemView.findViewById<ImageView>(R.id.favModel_iv)

            //아이템의 데이터로 뷰들을 설정
            //setImageResource : 이미지 넣어주기 위해
            model.setImageResource(modelList.model)

        }
    }


}