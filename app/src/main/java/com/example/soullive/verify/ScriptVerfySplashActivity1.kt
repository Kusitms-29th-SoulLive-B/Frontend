package com.example.soullive.verify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityVerifySplash1Binding


class ScriptVerfySplashActivity1:AppCompatActivity() {

    lateinit var binding: ActivityVerifySplash1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVerifySplash1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed(Runnable {
            // 앱의 main activity로 넘어가기
            val i = Intent(this@ScriptVerfySplashActivity1, VerifySplashActivity2::class.java)
            startActivity(i)
            // 현재 액티비티 닫기
            finish()
        }, 2000)

        binding.previous2Ib.setOnClickListener {
            finish()
        }


    }
}