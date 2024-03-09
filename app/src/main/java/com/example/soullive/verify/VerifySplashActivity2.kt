package com.example.soullive.verify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityVerifySplash1Binding
import com.example.soullive.databinding.ActivityVerifySplash2Binding

class VerifySplashActivity2 : AppCompatActivity() {


lateinit var binding: ActivityVerifySplash2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVerifySplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed(Runnable {
            // 앱의 main activity로 넘어가기
            val i = Intent(this@VerifySplashActivity2, DoVerifyActivity9::class.java)
            startActivity(i)
            // 현재 액티비티 닫기
            finish()
        }, 3000)

        binding.previous2Ib.setOnClickListener {
            finish()
        }
    }
}