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
    private var selectedStyleCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.guideBtn.setOnClickListener {
            val guideDialog = GuideDialogFragment()
            guideDialog.show(supportFragmentManager, guideDialog.tag)
        }

        val imageViews = listOf(
            binding.contents1, binding.contents2, binding.contents3,
            binding.contents4, binding.contents5, binding.contents6
        )

        val chooseViews = listOf(
            binding.choose1Iv, binding.choose2Iv, binding.choose3Iv,
            binding.choose4Iv, binding.choose5Iv, binding.choose6Iv
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
                chooseText.visibility = View.GONE
                selectedCount--
                updateButtonState(binding.nextVerify2Btn)
            }

        }

        val imageSytleViews = listOf(
            binding.style1, binding.style2, binding.style3,
            binding.style4, binding.style5, binding.style6
        )

        val chooseStyleViews = listOf(
            binding.styleChoose1, binding.styleChoose2, binding.styleChoose3,
            binding.styleChoose4, binding.styleChoose5, binding.styleChoose6
        )

        val chooseStyleText = listOf(
            binding.styleTextChoose1Tv, binding.styleTextChoose2Tv, binding.styleTextChoose3Tv,
            binding.styleTextChoose4Tv, binding.styleTextChoose5Tv, binding.styleTextChoose6Tv
        )

        for (i in imageViews.indices) {
            val basic = imageSytleViews[i]
            val choose = chooseStyleViews[i]
            val chooseText = chooseStyleText[i]

            basic.setOnClickListener {
                if (selectedStyleCount < 2) {
                    choose.visibility = View.VISIBLE
                    chooseText.visibility = View.VISIBLE
                    selectedStyleCount++
                }
                updateButtonState(binding.nextVerify2Btn)
            }

            choose.setOnClickListener {
                choose.visibility = View.GONE
                chooseText.visibility = View.GONE
                selectedStyleCount--
                updateButtonState(binding.nextVerify2Btn)
            }

        }
    }

    private fun updateButtonState(button: View) {
        if (selectedCount > 0 && selectedStyleCount > 0) {
            button.setBackgroundResource(R.drawable.main_btn)
            button.isEnabled = true // 버튼 활성화
        } else {
            button.setBackgroundResource(R.drawable.gray_btn)
            button.isEnabled = false // 버튼 비활성화
        }
    }

}