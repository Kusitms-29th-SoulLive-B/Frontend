package com.example.soullive.verify_result_go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.databinding.ActivityVerifyResultDetail1Binding

class VerifyResultDetailActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityVerifyResultDetail1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyResultDetail1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}