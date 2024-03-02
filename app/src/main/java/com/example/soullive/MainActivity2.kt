package com.example.soullive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val searchFragment = SearchFragment() // SearchFragment의 인스턴스 생성
        fragmentTransaction.add(R.id.frame_container, searchFragment) // container에 fragment 추가
        fragmentTransaction.commit() // 변경사항 반영


    }
}