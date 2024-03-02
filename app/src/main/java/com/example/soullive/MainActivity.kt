package com.example.soullive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log

import androidx.fragment.app.Fragment

import com.example.soullive.databinding.ActivityMainBinding
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 되어있지 않다면 로그인 페이지로
        //val intent = Intent(this, LogInActivity::class.java)
        //startActivity(intent)
        // 로그인 되어있으면 바로 메인 화면


        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        // 바텀 네비게이션 - 홈 버튼 클릭 시 HomeFragment 로드
        binding.homeBtn.setOnClickListener {
            loadFragment(HomeFragment())
            binding.homeIc.setImageResource(R.drawable.bottom_navigation_home_white)
            binding.exploreIc.setImageResource(R.drawable.bottom_navigation_explore_gray)
        }

        // 바텀 네비게이션 - 탐색 버튼 클릭 시 ExploreFragment 로드
        binding.exploreBtn.setOnClickListener {
            loadFragment(SearchFragment())
            binding.exploreIc.setImageResource(R.drawable.bottom_navigation_explore_white)
            binding.homeIc.setImageResource(R.drawable.bottom_navigation_home_gray)
        }

        // 바텀 네비게이션 - 검증 버튼 클릭 시
        binding.verifyBtn.setOnClickListener {
            loadFragment(VerifyFragment())
            binding.homeIc.setImageResource(R.drawable.bottom_navigation_home_gray)
            binding.exploreIc.setImageResource(R.drawable.bottom_navigation_explore_gray)
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // 백 스택에 추가하여 뒤로가기 버튼으로 이전 상태로 돌아갈 수 있도록
            .commit()

    }
}