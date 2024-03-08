package com.example.soullive.verify

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.soullive.databinding.ActivityScriptVerifyBinding
import java.io.InputStream

class ScriptVerifyActivity : AppCompatActivity() {

    lateinit var binding: ActivityScriptVerifyBinding



    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScriptVerifyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.close2Btn.setOnClickListener {
            finish()
        }


        binding.addFileIb.setOnClickListener {
        }


    }

}