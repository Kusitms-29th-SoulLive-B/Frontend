package com.example.soullive.verify_result_go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.databinding.ActivityVerifyResultDetail4Binding
import com.example.soullive.home.KeywordAdapter

class VerifyResultDetailActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityVerifyResultDetail4Binding
    lateinit var keywordAdapter: KeywordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyResultDetail4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 모델 키워드 목록
        keywordAdapter = KeywordAdapter(emptyList())
        binding.keywordRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.keywordRecyclerView.adapter = keywordAdapter

        val keywords = listOf("브랜드 평판 1위", "떠오르는", "고급스러운")
        keywordAdapter.updateData(keywords)

        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}