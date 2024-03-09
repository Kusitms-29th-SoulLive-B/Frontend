package com.example.soullive.verify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify6Binding
import com.example.soullive.databinding.ActivityScriptVerify2Binding

class ScriptVerifyActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityScriptVerify2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScriptVerify2Binding.inflate(layoutInflater)
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