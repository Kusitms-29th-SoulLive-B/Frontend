package com.example.soullive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.soullive.databinding.ActivityMainBinding
import com.kakao.sdk.common.util.Utility

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로그인 되어있지 않다면 로그인 페이지로
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
        // 로그인 되어있으면 바로 메인 화면

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)
    }
}