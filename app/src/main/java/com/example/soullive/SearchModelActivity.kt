package com.example.soullive

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.databinding.ActivitySearchmodelBinding

class SearchModelActivity : AppCompatActivity(){

    private lateinit var binding : ActivitySearchmodelBinding
    private lateinit var mAdapter: RecentModelRVAdapter


    private var modelList = arrayListOf<RecentModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchmodelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // mAdapter 초기화
        mAdapter = RecentModelRVAdapter(this, modelList)
        binding.recentSearchRecyclerview.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        binding.recentSearchRecyclerview.layoutManager = layout
        //binding.recentSearchRecyclerview.setHasFixedSize(true)

        binding.searchBtn.setOnClickListener {
            addNewItem()
        }
    }



    /*private fun addNewItem() {
        val editText = binding.searchEt
        val newItemText = editText.text.toString().trim()
        if (newItemText.isNotEmpty()) {
            val newItem = RecentModelItem(newItemText)
            modelList.add(newItem)
            mAdapter.notifyItemInserted(modelList.size - 1)
            editText.text.clear() // 입력 필드 비우기
        }
    }*/

    private fun addNewItem() {
        val editText = binding.searchEt
        val newItemText = editText.text.toString().trim()
        if (newItemText.isNotEmpty()) {
            val newItem = RecentModelItem(newItemText)
            mAdapter.addItem(newItem) // addItem 함수 호출로 리스트에 아이템 추가
            editText.text.clear() // 입력 필드 비우기
        }
    }

}