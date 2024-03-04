package com.example.soullive.verify

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.soullive.databinding.ActivityDoverify2Binding
import com.example.soullive.databinding.ActivityDoverify3Binding

class DoVerifyActivity3 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify3Binding
    private var isImageChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val basic1: ImageView = binding.keyword1Ib
        val choose1: ImageView =  binding.choose1Ib
        val basic2: ImageView = binding.keyword2Ib
        val choose2: ImageView =  binding.choose2Ib
        val basic3: ImageView = binding.keyword3Ib
        val choose3: ImageView =  binding.choose3Ib
        val basic4: ImageView = binding.keyword4Ib
        val choose4: ImageView =  binding.choose4Ib
        val basic5: ImageView = binding.keyword5Ib
        val choose5: ImageView =  binding.choose5Ib
        val basic6: ImageView = binding.keyword6Ib
        val choose6: ImageView =  binding.choose6Ib
        val basic7: ImageView = binding.keyword7Ib
        val choose7: ImageView =  binding.choose7Ib
        val basic8: ImageView = binding.keyword8Ib
        val choose8: ImageView =  binding.choose8Ib
        val basic9: ImageView = binding.keyword9Ib
        val choose9: ImageView =  binding.choose9Ib


        binding.previous2Ib.setOnClickListener {
            finish()
        }

        basic1.setOnClickListener {
            choose1.visibility = View.VISIBLE
        }
        choose1.setOnClickListener {
            choose1.visibility = View.GONE
            basic1.visibility = View.VISIBLE
        }
        basic2.setOnClickListener {
            choose2.visibility = View.VISIBLE
        }
        choose2.setOnClickListener {
            choose2.visibility = View.GONE
            basic2.visibility = View.VISIBLE
        }
        basic3.setOnClickListener {
            choose3.visibility = View.VISIBLE
        }
        choose3.setOnClickListener {
            choose3.visibility = View.GONE
            basic3.visibility = View.VISIBLE
        }
        basic4.setOnClickListener {
            choose4.visibility = View.VISIBLE
        }
        choose4.setOnClickListener {
            choose4.visibility = View.GONE
            basic4.visibility = View.VISIBLE
        }
        basic5.setOnClickListener {
            choose5.visibility = View.VISIBLE
        }
        choose5.setOnClickListener {
            choose5.visibility = View.GONE
            basic5.visibility = View.VISIBLE
        }
        basic6.setOnClickListener {
            choose6.visibility = View.VISIBLE
        }
        choose6.setOnClickListener {
            choose6.visibility = View.GONE
            basic6.visibility = View.VISIBLE
        }
        basic7.setOnClickListener {
            choose7.visibility = View.VISIBLE
        }
        choose7.setOnClickListener {
            choose7.visibility = View.GONE
            basic7.visibility = View.VISIBLE
        }
        basic8.setOnClickListener {
            choose8.visibility = View.VISIBLE
        }
        choose8.setOnClickListener {
            choose8.visibility = View.GONE
            basic8.visibility = View.VISIBLE
        }
        basic9.setOnClickListener {
            choose9.visibility = View.VISIBLE
        }
        choose9.setOnClickListener {
            choose9.visibility = View.GONE
            basic9.visibility = View.VISIBLE
        }

    }


}