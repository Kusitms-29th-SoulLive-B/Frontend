package com.example.soullive.verify

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.soullive.R
import com.example.soullive.databinding.ActivityDoverify2Binding

class DoVerifyActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityDoverify2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoverify2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previous2Ib.setOnClickListener {
            finish()
        }

        binding.detailEt.addTextChangedListener(textWatcher)

        binding.nextVerify2Btn.setOnClickListener {
            val intent = Intent(this, DoVerifyActivity3::class.java)

            startActivity(intent)
        }

        binding.root.setOnClickListener {
            // 화면의 다른 부분을 클릭하면 EditText의 포커스를 해제하고 키보드를 내림
            hideKeyboard()
        }

        binding.addFileIb.setOnClickListener {
            goGallery()
        }

    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 이메일이 입력되었을 때
            if (binding.detailEt.text.isNotEmpty()) {
                // 버튼의 배경 변경
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.main_btn)
                binding.nextVerify2Btn.isEnabled = true // 버튼 활성화
            } else {
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.gray_btn)
                binding.nextVerify2Btn.isEnabled = false // 버튼 비활성화
            }
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun hideKeyboard() {
        binding.detailEt.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun goGallery() {
        // Check for necessary permissions
        val writePermission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val readPermission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )

        // Request permissions if not granted
        if (writePermission == PackageManager.PERMISSION_DENIED || readPermission == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                1
            )
        } else {
            // Launch gallery intent
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, GALLERY_REQUEST_CODE)
        }
    }

    companion object {
        private const val GALLERY_REQUEST_CODE = 1001
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            // Gallery intent was successful, handle the selected image here
            val selectedImageUri = data?.data
            // Do something with the selected image URI
            Glide.with(this).load(selectedImageUri).into(binding.imageView)
            if (selectedImageUri != null){
                binding.addFileIb.visibility = View.GONE
                binding.textView5.visibility = View.GONE
            }
        }
    }
}