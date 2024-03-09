package com.example.soullive.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soullive.R
import com.example.soullive.databinding.ActivityHomeAiModelDetailBinding

class HomeAiModelDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeAiModelDetailBinding
    lateinit var listModelAdapter: HomeAiModelDetailAdapter
    lateinit var galleryModelAdapter: HomeAiModelDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeAiModelDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listModelAdapter = HomeAiModelDetailAdapter(emptyList(),false)
        galleryModelAdapter = HomeAiModelDetailAdapter(emptyList(),true)

        // 초기엔 리스트 모델 출력
        binding.modelRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.modelRecyclerView.adapter = listModelAdapter

        loadListModel()

        // 리스트 버튼 클릭 시
        binding.listBtn.setOnClickListener {
            binding.modelRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.modelRecyclerView.adapter = listModelAdapter

            loadListModel() // 리스트 모델 출력

            binding.listBtn.setImageResource(R.drawable.ic_list_white)
            binding.galleryBtn.setImageResource(R.drawable.ic_gallery_gray)
        }

        // 갤러리 버튼 클릭 시
        binding.galleryBtn.setOnClickListener {
            binding.modelRecyclerView.layoutManager = GridLayoutManager(this, 2)
            binding.modelRecyclerView.adapter = galleryModelAdapter

            loadGalleryModel() // 그리드 모델 출력

            binding.listBtn.setImageResource(R.drawable.ic_list_gray)
            binding.galleryBtn.setImageResource(R.drawable.ic_gallery_white)
        }

        binding.backBtn.setOnClickListener {
            finish()
        }

    }

    private fun loadListModel() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            ModelAi(1, "고윤정", "배우", "떠오르는", "고급스러운",
                R.drawable.img_model_1, "20", "여성"),
            ModelAi(2, "민스코", "인플루언서", "친근한", "감각있는",
                R.drawable.img_model_home_1, "30", "여성"),
            ModelAi(3, "이도현", "배우", "부드러운", "성실한",
                R.drawable.img_model_sample, "20", "여성"),
            ModelAi(4, "안유진", "아이돌 가수", "밝은", "친근한",
                R.drawable.img_model_home_2, "10", "모두"),
            ModelAi(5, "잇섭", "인플루언서", "유머스러운", "밝은",
                R.drawable.img_model_it_detail, "30", "남성"),
            ModelAi(6, "노윤서", "배우", "고급진", "청순한",
                R.drawable.img_model_home_7, "20", "여성"),
            ModelAi(1, "고윤정", "배우", "떠오르는", "고급스러운",
                R.drawable.img_model_1, "20", "여성"),
            ModelAi(2, "민스코", "인플루언서", "친근한", "감각있는",
                R.drawable.img_model_home_1, "30", "여성"),
            ModelAi(3, "이도현", "배우", "부드러운", "성실한",
                R.drawable.img_model_sample, "20", "여성"),
            ModelAi(4, "안유진", "아이돌 가수", "밝은", "친근한",
                R.drawable.img_model_home_2, "10", "모두"),
        )

        // 어댑터에 데이터 설정
        listModelAdapter.updateData(models)
    }

    private fun loadGalleryModel() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            ModelAi(1, "고윤정", "배우", "떠오르는", "고급스러운",
                R.drawable.img_model_1, "20", "여성"),
            ModelAi(2, "민스코", "인플루언서", "친근한", "감각있는",
                R.drawable.img_model_home_1, "30", "여성"),
            ModelAi(3, "이도현", "배우", "부드러운", "성실한",
                R.drawable.img_model_sample, "20", "여성"),
            ModelAi(4, "안유진", "아이돌 가수", "밝은", "친근한",
                R.drawable.img_model_home_2, "10", "모두"),
            ModelAi(5, "잇섭", "인플루언서", "유머스러운", "밝은",
                R.drawable.img_model_it_detail, "30", "남성"),
            ModelAi(6, "노윤서", "배우", "고급진", "청순한",
                R.drawable.img_model_home_7, "20", "여성"),
            ModelAi(1, "고윤정", "배우", "떠오르는", "고급스러운",
                R.drawable.img_model_1, "20", "여성"),
            ModelAi(2, "민스코", "인플루언서", "친근한", "감각있는",
                R.drawable.img_model_home_1, "30", "여성"),
            ModelAi(3, "이도현", "배우", "부드러운", "성실한",
                R.drawable.img_model_sample, "20", "여성"),
            ModelAi(4, "안유진", "아이돌 가수", "밝은", "친근한",
                R.drawable.img_model_home_2, "10", "모두"),
        )

        // 어댑터에 데이터 설정
        galleryModelAdapter.updateData(models)
    }
}