package com.example.soullive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify2Binding
import com.example.soullive.databinding.ActivityGuideVerifyBinding

class GuideVerifyActivity : AppCompatActivity() {

    lateinit var binding: ActivityGuideVerifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuideVerifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.needVerify2Btn.setOnClickListener {

        }

        binding.skipVerify2Btn.setOnClickListener {

        }

        binding.previous2Ib.setOnClickListener {
            finish()
        }
    }
}