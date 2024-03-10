package com.example.soullive.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.home.RecentModelRVAdapter
import com.example.soullive.databinding.ActivitySearchmodelBinding
import com.example.soullive.home.ModelDetailActivity

class SearchModelActivity : AppCompatActivity(){

    private lateinit var binding : ActivitySearchmodelBinding
    private lateinit var recentSearchAdapter: RecentModelRVAdapter
    private val recentSearchItems = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchmodelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // mAdapter 초기화
        recentSearchAdapter = RecentModelRVAdapter(this, recentSearchItems)
        binding.recentSearchRecyclerview.adapter = recentSearchAdapter

        binding.searchBtn.setOnClickListener {
            val newItem = binding.searchEt.text.toString() // EditText에서 텍스트를 가져옴
            if (newItem.isNotEmpty()) { // 텍스트가 비어있지 않은 경우에만 처리
                recentSearchItems.add(newItem) // 리스트에 아이템 추가
                recentSearchAdapter.notifyDataSetChanged() // 어댑터에 변경 사항을 알림
                binding.searchEt.text.clear() // EditText의 텍스트를 지움
            }
            val intent = Intent(this, ModelDetailActivity::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }




}