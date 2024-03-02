package com.example.soullive

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soullive.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var aiModelAdapter: HomeAiModelAdapter
    private lateinit var aiModelRecyclerView: RecyclerView
    private lateinit var selectedModelAdapter: HomeSelectedModelAdapter
    private lateinit var selectedModelRecyclerView: RecyclerView
    private lateinit var keywordModelAdapter: HomeKeywordModelAdapter
    private lateinit var keywordModelRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        aiModelRecyclerView = binding.aiModelRecyclerView
        selectedModelRecyclerView = binding.selectedModelRecyclerView
        keywordModelRecyclerView = binding.keywordModelRecyclerView

        val horizontalLayoutManager1 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val horizontalLayoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val verticalLayoutManager = LinearLayoutManager(requireContext())

        aiModelRecyclerView.layoutManager = horizontalLayoutManager1
        selectedModelRecyclerView.layoutManager = horizontalLayoutManager2
        keywordModelRecyclerView.layoutManager = verticalLayoutManager

        aiModelAdapter = HomeAiModelAdapter(emptyList()) // 초기에 빈 목록으로 어댑터 설정
        aiModelRecyclerView.adapter = aiModelAdapter // 리사이클러뷰에 어댑터 설정

        selectedModelAdapter = HomeSelectedModelAdapter(emptyList())
        selectedModelRecyclerView.adapter = selectedModelAdapter

        keywordModelAdapter = HomeKeywordModelAdapter(emptyList())
        keywordModelRecyclerView.adapter = keywordModelAdapter

        loadAiModelList()  // ai 추천 모델 목록 출력
        loadSelectedModelList() // 기업 별 선택된 모델 목록 출력
        loadKeywordModelList() // 키워드 별 모델 목록 출력

        // 이런 모델은 어때요? 전체 보기 클릭 시
        binding.aiMoreBtn.setOnClickListener {
            val intent = Intent(requireContext(), HomeAiModelDetailActivity::class.java)
            startActivity(intent)
        }

        // 키워드 클릭 시 해당 모델 리스트 출력
        binding.keyword1.setOnClickListener {
            // 키워드들의 색상 변경
            binding.keyword1.setBackgroundResource(R.drawable.bg_keyword_white)
            binding.keyword1Txt.setTextColor(resources.getColor(R.color.bg))

            binding.keyword2.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword2Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword3.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword3Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword4.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword4Txt.setTextColor(resources.getColor(R.color.white))
        }

        binding.keyword2.setOnClickListener {
            // 키워드들의 색상 변경
            binding.keyword2.setBackgroundResource(R.drawable.bg_keyword_white)
            binding.keyword2Txt.setTextColor(resources.getColor(R.color.bg))

            binding.keyword1.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword1Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword3.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword3Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword4.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword4Txt.setTextColor(resources.getColor(R.color.white))
        }

        binding.keyword3.setOnClickListener {
            // 키워드들의 색상 변경
            binding.keyword3.setBackgroundResource(R.drawable.bg_keyword_white)
            binding.keyword3Txt.setTextColor(resources.getColor(R.color.bg))

            binding.keyword2.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword2Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword1.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword1Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword4.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword4Txt.setTextColor(resources.getColor(R.color.white))
        }

        binding.keyword4.setOnClickListener {
            // 키워드들의 색상 변경
            binding.keyword4.setBackgroundResource(R.drawable.bg_keyword_white)
            binding.keyword4Txt.setTextColor(resources.getColor(R.color.bg))

            binding.keyword2.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword2Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword3.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword3Txt.setTextColor(resources.getColor(R.color.white))
            binding.keyword1.setBackgroundResource(R.drawable.bg_keyword)
            binding.keyword1Txt.setTextColor(resources.getColor(R.color.white))
        }

        return binding.root
    }

    private fun loadAiModelList() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            Model(2, "아이유", "가수", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
        )

        // 어댑터에 데이터 설정
        aiModelAdapter.updateData(models)
    }

    private fun loadSelectedModelList() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            Model(2, "아이유", "가수", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
        )

        // 어댑터에 데이터 설정
        selectedModelAdapter.updateData(models)
    }

    private fun loadKeywordModelList() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            Model(2, "아이유", "가수", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
            Model(1, "이도현", "베우", ""),
        )

        // 어댑터에 데이터 설정
        keywordModelAdapter.updateData(models)

        setRecyclerViewHeight()
    }

    // 키워드 모델 RecyclerView의 높이를 동적으로 설정
    private fun setRecyclerViewHeight() {
        val itemCount = keywordModelAdapter.itemCount
        val itemHeight = 116.dpToPx() // 아이템의 높이
        val recyclerViewHeight = itemCount * itemHeight

        val layoutParams = keywordModelRecyclerView.layoutParams
        layoutParams.height = recyclerViewHeight
        keywordModelRecyclerView.layoutParams = layoutParams
    }

    fun Int.dpToPx(): Int {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }
}