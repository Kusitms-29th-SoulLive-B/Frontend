package com.example.soullive.verify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify5Binding
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


    }
}