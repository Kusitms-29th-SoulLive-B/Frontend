package com.example.soullive.verify_result_go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.R
import com.example.soullive.databinding.ActivityVerifyResultDetail2Binding
import com.example.soullive.home.KeywordAdapter

class VerifyResultDetailActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityVerifyResultDetail2Binding
    lateinit var keywordAdapter: KeywordAdapter
    lateinit var contentsAdapter: ModelContentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyResultDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 모델 키워드 목록
        keywordAdapter = KeywordAdapter(emptyList())
        binding.keywordRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.keywordRecyclerView.adapter = keywordAdapter

        val keywords = listOf("브랜드 평판 1위", "떠오르는", "고급스러운")
        keywordAdapter.updateData(keywords)

        // 모델 콘텐츠 목록
        contentsAdapter = ModelContentsAdapter(emptyList())
        binding.contentsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.contentsRecyclerView.adapter = contentsAdapter

        loadContentsList()

        binding.backBtn.setOnClickListener {
            finish()
        }
    }

    private fun loadContentsList() {
        // 임시로 더미 데이터 생성
        val models = listOf(R.drawable.img_model_contents_1, R.drawable.img_model_contents_2,
            R.drawable.img_model_contents_3)

        // 어댑터에 데이터 설정
        contentsAdapter.updateData(models)
    }
}