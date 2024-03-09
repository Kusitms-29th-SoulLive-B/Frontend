package com.example.soullive.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.MainActivity
import com.example.soullive.databinding.ActivityOnboardingDoneBinding

class OnboardingDoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityOnboardingDoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOnboardingDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.closeBtn.setOnClickListener { //닫기 클릭 시
            // 모든 온보딩 액티비티를 종료하고 메인으로 이동
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        binding.doneBtn.setOnClickListener { //완료 클릭 시
            // 모든 온보딩 액티비티를 종료하고 메인으로 이동
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("showPopup", true) // 팝업을 보여주기 위한 플래그를 전달
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}