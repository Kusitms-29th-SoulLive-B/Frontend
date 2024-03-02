package com.example.soullive

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
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

        binding.detailEt.addTextChangedListener(textWatcher)

        binding.nextVerify2Btn.setOnClickListener {
            val intent = Intent(this, GuideVerifyActivity::class.java)

            startActivity(intent)
        }

        binding.root.setOnClickListener {
            // 화면의 다른 부분을 클릭하면 EditText의 포커스를 해제하고 키보드를 내림
            hideKeyboard()
        }

    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 이메일이 입력되었을 때
            if (binding.detailEt.text.isNotEmpty()) {
                // 버튼의 배경 변경
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.main_btn)
                binding.nextVerify2Btn.isEnabled = true // 버튼 활성화
            } else {
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.gray_btn)
                binding.nextVerify2Btn.isEnabled = false // 버튼 비활성화
            }
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun hideKeyboard() {
        binding.detailEt.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}