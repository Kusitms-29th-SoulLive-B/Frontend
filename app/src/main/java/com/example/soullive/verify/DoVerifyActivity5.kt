package com.example.soullive.verify

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify4Binding
import com.example.soullive.databinding.ActivityDoverify5Binding

class DoVerifyActivity5:AppCompatActivity() {

    lateinit var binding: ActivityDoverify5Binding
    private var selectedCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.guideBtn.setOnClickListener {
            val guideDialog = GuideDialogFragment()
            guideDialog.show(supportFragmentManager, guideDialog.tag)
        }

        val textViews = listOf(
            binding.girlTv, binding.boyTv

        )

        val chooseViews = listOf(
            binding.girlChooseBtn, binding.boyChooseBtn
        )

        val chooseText1 = listOf(
            binding.girlChooseTv, binding.boyChooseTv
        )

        for (i in textViews.indices) {
            val basic = textViews[i]
            val choose = chooseViews[i]
            val chooseText = chooseText1[i]

            basic.setOnClickListener {
                if (selectedCount < 2) {
                    choose.visibility = View.VISIBLE
                    chooseText.visibility = View.VISIBLE
                    selectedCount++
                }
                if (selectedCount == 1){
                    binding.checkAllBtn.isEnabled
                }
                updateButtonState(binding.nextVerify2Btn)
            }

            choose.setOnClickListener {
                choose.visibility = View.GONE
                chooseText.visibility = View.GONE
                selectedCount--
                updateButtonState(binding.nextVerify2Btn)
            }
            binding.checkAllBtn.setOnClickListener {
                binding.boyChooseBtn.visibility = View.GONE
                binding.girlChooseBtn.visibility = View.GONE
                binding.boyChooseTv.visibility = View.GONE
                binding.girlChooseTv.visibility = View.GONE
                selectedCount-=2
            }
        }

        binding.ageSlider.setStepSize(10f)


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