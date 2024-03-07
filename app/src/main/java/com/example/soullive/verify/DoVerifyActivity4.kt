package com.example.soullive.verify

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify3Binding
import com.example.soullive.databinding.ActivityDoverify4Binding

class DoVerifyActivity4 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify4Binding
    private var selectedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageViews = listOf(
            binding.contents1, binding.contents2, binding.contents3,
            binding.contents4, binding.contents5, binding.contents6
        )

        val chooseViews = listOf(
            binding.choose1Iv, binding.choose2Iv, binding.choose3Iv,
            binding.choose4Iv, binding.choose5Iv, binding.choose6Iv
        )

        val textViews = listOf(
            binding.text1Tv, binding.text2Tv, binding.text3Tv,
            binding.text4Tv, binding.text5Tv, binding.text6Tv
        )

        val chooseText = listOf(
            binding.choose1Tv, binding.choose2Tv, binding.choose3Tv,
            binding.choose4Tv, binding.choose5Tv, binding.choose6Tv
        )

        for (i in imageViews.indices) {
            val basic = imageViews[i]
            val choose = chooseViews[i]
            val chooseText = chooseText[i]

            basic.setOnClickListener {
                if (selectedCount < 2) {
                    choose.visibility = View.VISIBLE
                    chooseText.visibility = View.VISIBLE
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