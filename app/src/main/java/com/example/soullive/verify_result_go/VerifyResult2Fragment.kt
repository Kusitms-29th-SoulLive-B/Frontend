package com.example.soullive.verify_result_go

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.R
import com.example.soullive.databinding.FragmentVerifyResult2Binding
import com.example.soullive.home.KeywordAdapter
import com.example.soullive.home.ModelResult

class VerifyResult2Fragment : Fragment(), VerifyResultModelAdapter.ModelItemClickListener {
    lateinit var binding: FragmentVerifyResult2Binding
    lateinit var modelAdapter: VerifyResultModelAdapter
    lateinit var keywordAdapter: KeywordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerifyResult2Binding.inflate(inflater, container, false)

        // 모델 결과 목록
        modelAdapter = VerifyResultModelAdapter(emptyList(), this)
        binding.modelRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.modelRecyclerView.adapter = modelAdapter

        loadModelList()

        // 모델 키워드 목록
        keywordAdapter = KeywordAdapter(emptyList())
        binding.keywordRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.keywordRecyclerView.adapter = keywordAdapter

        val keywords = listOf("브랜드 평판 1위", "떠오르는", "고급스러운")
        keywordAdapter.updateData(keywords)

        // 검증 완료-화제성 페이지로 이동
        binding.modelImg.setOnClickListener {
            val intent = Intent(context, VerifyResultDetailActivity2::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    private fun loadModelList() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            ModelResult(1, 1, "고윤정", "영화ㆍ드라마 배우", "MAA",
                "2019년 데뷔", "브랜드 평판 1위", "떠오르는", "고급스러운",
                R.drawable.img_model_1),
            ModelResult(2, 2, "모델2", "영화ㆍ드라마 배우", "MAA",
                "2019년 데뷔", "브랜드 평판 2위", "떠오르는", "고급스러운",
                R.drawable.img_model_3),
            ModelResult(3, 3, "모델3", "영화ㆍ드라마 배우", "MAA",
                "2019년 데뷔", "브랜드 평판 3위", "떠오르는", "고급스러운",
                R.drawable.img_model_2),
            ModelResult(4, 4, "모델4", "영화ㆍ드라마 배우", "MAA",
                "2019년 데뷔", "브랜드 평판 4위", "떠오르는", "고급스러운",
                R.drawable.img_model_4),
        )

        // 어댑터에 데이터 설정
        modelAdapter.updateData(models)

        // 첫 번째 아이템의 배경 이미지뷰를 보이도록 설정
        modelAdapter.setSelectedPosition(0)
    }

    override fun onModelItemClick(model: ModelResult) {
        // 필요한 모든 정보를 바인딩하여 UI를 업데이트
        binding.modelName.text = model.name
        binding.modelJob.text = model.job
        binding.modelAgency.text = model.company
        binding.modelDebut.text = model.debut
        binding.ranking.text = "${model.ranking}"
        binding.modelImg.setImageResource(model.image)

        val keywords = listOf(model.keyword1, model.keyword2, model.keyword3)
        keywordAdapter.updateData(keywords)
    }

}