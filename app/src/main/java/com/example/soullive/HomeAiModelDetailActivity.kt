package com.example.soullive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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
            Model(1, "모델1", "직업1", "이미지1"),
            Model(2, "모델2", "직업2", "이미지2"),
            Model(3, "모델3", "직업3", "이미지3"),
            Model(4, "모델4", "직업4", "이미지4"),
            Model(5, "모델5", "직업5", "이미지5")
        )

        // 어댑터에 데이터 설정
        listModelAdapter.updateData(models)
    }

    private fun loadGalleryModel() {
        // 임시로 더미 데이터 생성
        val models = listOf(
            Model(1, "모델1", "직업1", "이미지1"),
            Model(2, "모델2", "직업2", "이미지2"),
            Model(3, "모델3", "직업3", "이미지3"),
            Model(4, "모델4", "직업4", "이미지4"),
            Model(5, "모델5", "직업5", "이미지5")
        )

        // 어댑터에 데이터 설정
        galleryModelAdapter.updateData(models)
    }
}