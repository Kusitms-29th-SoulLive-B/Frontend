package com.example.soullive.verify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify2Binding
import com.example.soullive.databinding.ActivityDoverify3Binding

class DoVerifyActivity3 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }


    }
}