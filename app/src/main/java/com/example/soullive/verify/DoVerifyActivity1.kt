package com.example.soullive.verify

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify1Binding

class DoVerifyActivity1 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoverify1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productNameEt.addTextChangedListener(textWatcher)

        binding.nextVerify1Btn.setOnClickListener {
            val intent = Intent(this, DoVerifyActivity2::class.java)
            startActivity(intent)
        }

        binding.previous1Ib.setOnClickListener {
            finish()
        }

        binding.close1Btn.setOnClickListener {
            finish()
        }

        binding.root.setOnClickListener {
            // 화면의 다른 부분을 클릭하면 EditText의 포커스를 해제하고 키보드를 내림
            hideKeyboard()
        }

        binding.showPreviousIb.setOnClickListener {

            val bottomSheet = SaveBottomsheetDialogFragment(this)
            bottomSheet.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
            bottomSheet.show(supportFragmentManager,bottomSheet.tag)

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

    private fun hideKeyboard() {
        binding.productNameEt.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

}