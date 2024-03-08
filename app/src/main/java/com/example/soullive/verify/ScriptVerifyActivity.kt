package com.example.soullive.verify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify9Binding
import com.example.soullive.databinding.ActivityScriptVerifyBinding

class ScriptVerifyActivity : AppCompatActivity() {

    lateinit var binding: ActivityScriptVerifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScriptVerifyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.close2Btn.setOnClickListener {
            finish()
        }



    }
}