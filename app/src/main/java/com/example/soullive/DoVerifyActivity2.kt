package com.example.soullive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify1Binding
import com.example.soullive.databinding.ActivityDoverify2Binding

class DoVerifyActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

    }
}