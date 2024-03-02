package com.example.soullive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.databinding.ActivityModelDetailBinding

class ModelDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelDetailBinding
    lateinit var keywordAdapter: KeywordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityModelDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        keywordAdapter = KeywordAdapter(emptyList())

        // 모델 키워드 리스트
        binding.keywordRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.keywordRecyclerView.adapter = keywordAdapter
        loadModelKeyword()

        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun loadModelKeyword() {
        // 임시로 더미 데이터 생성
        val keywords = listOf("브랜드 평판 1위", "떠오르는", "고급스러운")

        // 어댑터에 데이터 설정
        keywordAdapter.updateData(keywords)
    }
}