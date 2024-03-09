package com.example.soullive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import androidx.appcompat.app.AlertDialog

import androidx.fragment.app.Fragment

import com.example.soullive.databinding.ActivityMainBinding
import com.example.soullive.databinding.PopupLayoutBinding
import com.example.soullive.home.HomeFragment
import com.example.soullive.search.SearchFragment
import com.example.soullive.verify.VerifyFragment
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        // 팝업을 표시 여부 확인
        handleIntent(intent)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // 백 스택에 추가하여 뒤로가기 버튼으로 이전 상태로 돌아갈 수 있도록
            .commit()

    }
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val showPopup = intent.getBooleanExtra("showPopup", false)
        if (showPopup) {
            // 팝업을 표시하는 함수 호출
            showPopup()
        }
    }

    private fun showPopup() {
        // 팝업 레이아웃을 인플레이션
        val popupLayoutBinding = PopupLayoutBinding.inflate(layoutInflater)
        val popupView = popupLayoutBinding.root

        // AlertDialog.Builder를 사용하여 팝업을 생성하고 레이아웃을 설정
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(popupView)

        // AlertDialog를 생성하고 보여줌
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

        // 팝업 레이아웃 내의 버튼에 대한 클릭 리스너를 설정
        popupLayoutBinding.no.setOnClickListener {
            alertDialog.dismiss() // 팝업 닫기
        }

        popupLayoutBinding.closeBtn.setOnClickListener {
            alertDialog.dismiss() // 팝업 닫기
        }

        popupLayoutBinding.go.setOnClickListener {
            alertDialog.dismiss() // 팝업 닫기

            loadFragment(VerifyFragment())
            binding.homeIc.setImageResource(R.drawable.bottom_navigation_home_gray)
            binding.exploreIc.setImageResource(R.drawable.bottom_navigation_explore_gray)
        }
    }
}