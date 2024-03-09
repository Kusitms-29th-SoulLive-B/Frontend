package com.example.soullive.verify

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify6Binding

class DoVerifyActivity6 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.nextVerify2Btn.setOnClickListener {
            val intent = Intent(this, VerfySplashActivity1::class.java)
            startActivity(intent)
        }


    }
}