package com.example.soullive

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify1Binding
import com.example.soullive.databinding.ActivityMainBinding

class DoVerifyActivity1 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoverify1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productNameEt.addTextChangedListener(textWatcher)

        binding.nextVerify1Btn.setOnClickListener {

        }

    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 이메일이 입력되었을 때
            if (binding.productNameEt.text.isNotEmpty()) {
                // 버튼의 배경 변경
                binding.nextVerify1Btn.setBackgroundResource(R.drawable.main_btn)
                binding.nextVerify1Btn.isEnabled = true // 버튼 활성화
            } else {
                binding.nextVerify1Btn.setBackgroundResource(R.drawable.gray_btn)
                binding.nextVerify1Btn.isEnabled = false // 버튼 비활성화
            }
        }

        override fun afterTextChanged(s: Editable?) {}
    }

}