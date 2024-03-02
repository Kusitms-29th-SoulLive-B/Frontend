package com.example.soullive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.databinding.ActivityOnboardingDoneBinding
import com.example.soullive.databinding.ActivityOnboardingEmailBinding

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
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}