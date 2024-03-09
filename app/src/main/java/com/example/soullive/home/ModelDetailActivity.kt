package com.example.soullive.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.R
import com.example.soullive.databinding.ActivityModelDetailBinding

class ModelDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelDetailBinding
    lateinit var keywordAdapter: KeywordAdapter
    lateinit var recentAdAdapter: ModelDetailAdAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityModelDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        keywordAdapter = KeywordAdapter(emptyList())
        recentAdAdapter = ModelDetailAdAdapter(emptyList())

        // 모델 키워드 리스트
        binding.keywordRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.keywordRecyclerView.adapter = keywordAdapter
        loadModelKeyword()

        // 모델 최근 광고 리스트
        binding.adRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.adRecyclerView.adapter = recentAdAdapter
        loadAdList()

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

    private fun loadAdList() {
        // 임시로 더미 데이터 생성
        val ads = listOf(
            Ad(R.drawable.img_model_ad_detail, R.drawable.img_ad_logo_sample),
            Ad(R.drawable.img_model_ad_detail_2, R.drawable.img_logo_pu))

        // 어댑터에 데이터 설정
        recentAdAdapter.updateData(ads)
    }
}