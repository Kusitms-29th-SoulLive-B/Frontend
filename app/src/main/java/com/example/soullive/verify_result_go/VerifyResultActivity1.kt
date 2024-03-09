package com.example.soullive.verify_result_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soullive.MainActivity
import com.example.soullive.R
import com.example.soullive.databinding.ActivityVerifyResult1Binding
import com.google.android.material.tabs.TabLayout

class VerifyResultActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityVerifyResult1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyResult1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setTabLayout()

        supportFragmentManager.beginTransaction()
            .replace(R.id.tab_layout_container, VerifyResult1Fragment().apply {})
            .commit()

        binding.backBtn.setOnClickListener { // 뒤로 가기 버튼
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

    }

    private fun setTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResult1Fragment().apply {})
                            .commit()
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResult2Fragment().apply {})
                            .commit()
                    }
                    2 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResult3Fragment().apply {})
                            .commit()
                    }
                    3 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, VerifyResult4Fragment().apply {})
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}