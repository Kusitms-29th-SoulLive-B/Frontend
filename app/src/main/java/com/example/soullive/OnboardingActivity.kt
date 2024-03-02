package com.example.soullive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.example.soullive.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 텍스트 변경 이벤트를 감지
        binding.inputName.addTextChangedListener(textWatcher)
        binding.inputType.addTextChangedListener(textWatcher)

        binding.inputTypeBtn.setOnClickListener { // 기업 타입 선택
            val selectTypeDialog = BottomCompanyTypeFragment()
            selectTypeDialog.setTypeChangeListener(object : BottomCompanyTypeFragment.TypeChangeListener {
                override fun onTypeChanged(type: String) {
                    binding.inputType.text = type
                    binding.inputType.setTextColor(ContextCompat.getColor(this@OnboardingActivity, android.R.color.white))
                    binding.txtType.visibility = View.VISIBLE
                }
            })
            selectTypeDialog.show(supportFragmentManager, "select_type_dialog")
        }

        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, OnboardingEmailActivity::class.java)
            startActivity(intent)
        }

        binding.root.setOnClickListener {
            // 화면의 다른 부분을 클릭하면 EditText의 포커스를 해제하고 키보드를 내림
            hideKeyboard()
        }

        binding.backBtn.setOnClickListener { //뒤로 가기 클릭 시
            finish()
        }
    }

    // 텍스트 변경 감지
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 기업명/분류 가 모두 입력되었을 때
            if (binding.inputName.text.isNotEmpty() && binding.inputType.text != "기업 분류" ) {
                // 버튼의 배경 변경
                binding.nextBtn.setBackgroundResource(R.drawable.main_btn)
                binding.nextBtn.isEnabled = true // 버튼 활성화
            } else {
                binding.nextBtn.setBackgroundResource(R.drawable.gray_btn)
                binding.nextBtn.isEnabled = false // 버튼 비활성화
            }
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun hideKeyboard() {
        binding.inputName.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}