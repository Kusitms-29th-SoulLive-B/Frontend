package com.example.soullive.verify

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.example.soullive.R
import com.example.soullive.databinding.FragmentBottomsheetDialogBinding
import com.example.soullive.databinding.FragmentGuideDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class VerifyBottomSheetDialogFragment(context: Context) : BottomSheetDialogFragment() {

    lateinit var binding : FragmentBottomsheetDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBottomsheetDialogBinding.inflate(inflater, container, false)

        binding.editText.addTextChangedListener(textWatcher)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        binding.nextVerify2Btn.setOnClickListener {
            val intent = Intent(requireContext(), DoVerifyActivity4::class.java)
            startActivity(intent)
            dismiss()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 이메일이 입력되었을 때
            if (binding.editText.text.isNotEmpty()) {
                // 버튼의 배경 변경
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.main_btn)
                binding.nextVerify2Btn.isEnabled = true // 버튼 활성화
            } else {
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.gray_btn)
                binding.nextVerify2Btn.isEnabled = false // 버튼 비활성화
            }

            if (binding.editText.length() > 30){
                Toast.makeText(requireContext(), "최대 30자까지 입력가능합니다.",Toast.LENGTH_SHORT).show()

            } else{
                binding.textCount.setText("${binding.editText.length()}/30")
                binding.eraseBtn.setOnClickListener {
                    binding.editText.setText("")
                }
            }
        }

        override fun afterTextChanged(s: Editable?) {}
    }

}