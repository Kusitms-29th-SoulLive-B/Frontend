package com.example.soullive.verify

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify2Binding
import com.example.soullive.databinding.ActivityDoverify31Binding
import com.example.soullive.databinding.ActivityDoverify3Binding

class DoVerifyActivity3_1 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify31Binding
    private var selectedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify31Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val imageViews = listOf(
            binding.keyword1Ib, binding.keyword2Ib, binding.keyword3Ib,
            binding.keyword4Ib, binding.keyword5Ib, binding.keyword6Ib,
            binding.keyword7Ib, binding.keyword8Ib, binding.keyword9Ib
        )

        val chooseViews = listOf(
            binding.choose1Ib, binding.choose2Ib, binding.choose3Ib,
            binding.choose4Ib, binding.choose5Ib, binding.choose6Ib,
            binding.choose7Ib, binding.choose8Ib, binding.choose9Ib
        )

        for (i in imageViews.indices) {
            val basic = imageViews[i]
            val choose = chooseViews[i]

            basic.setOnClickListener {
                if (selectedCount < 3) {
                    choose.visibility = View.VISIBLE
                    selectedCount++
                }
                updateButtonState(binding.nextVerify2Btn)
            }

            choose.setOnClickListener {
                choose.visibility = View.GONE
                selectedCount--
                updateButtonState(binding.nextVerify2Btn)
            }

        }

        binding.nextVerify2Btn.setOnClickListener {
            val intent = Intent(this, DoVerifyActivity4::class.java)
            startActivity(intent)
        }

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.guideBtn.setOnClickListener {
            val guideDialog = GuideDialogFragment()
            guideDialog.show(supportFragmentManager, guideDialog.tag)
        }

        binding.nextVerify3Btn.setOnClickListener {
            val bottomSheet = VerifyBottomSheetDialogFragment(this)
            bottomSheet.setStyle(DialogFragment.STYLE_NORMAL, R.style.RoundCornerBottomSheetDialogTheme)
            bottomSheet.show(supportFragmentManager,bottomSheet.tag)

        }



    }

    private fun updateButtonState(button: View) {
        if (selectedCount > 0) {
            button.setBackgroundResource(R.drawable.main_btn)
            button.isEnabled = true // 버튼 활성화
        } else {
            button.setBackgroundResource(R.drawable.gray_btn)
            button.isEnabled = false // 버튼 비활성화
        }
    }



}