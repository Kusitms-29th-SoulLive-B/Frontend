package com.example.soullive.verify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify9Binding

class DoVerifyActivity9:AppCompatActivity() {

    lateinit var binding: ActivityDoverify9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }


    }
}