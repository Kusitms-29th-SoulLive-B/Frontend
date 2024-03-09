package com.example.soullive.verify_result_it

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.R
import com.example.soullive.databinding.ActivityVerifyResult2Binding
import com.google.android.material.tabs.TabLayout

class VerifyResultActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityVerifyResult2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyResult2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setTabLayout()

        supportFragmentManager.beginTransaction()
            .replace(R.id.tab_layout_container, VerifyResultFragment().apply {})
            .commit()

        binding.backBtn.setOnClickListener { // 뒤로 가기 버튼
            finish()
        }
    }

    private fun setTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResultFragment().apply {})
                            .commit()
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResultFragment().apply {})
                            .commit()
                    }
                    2 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResultFragment().apply {})
                            .commit()
                    }
                    3 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResultFragment().apply {})
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}