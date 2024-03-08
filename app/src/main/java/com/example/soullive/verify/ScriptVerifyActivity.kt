package com.example.soullive.verify

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.soullive.R
import com.example.soullive.databinding.ActivityScriptVerifyBinding
import java.io.InputStream

class ScriptVerifyActivity : AppCompatActivity() {

    lateinit var binding: ActivityScriptVerifyBinding


    private val FILE_SELECT_REQUEST_CODE = 123

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
            openFilePicker()
        }

        binding.nextVerify2Btn.setOnClickListener {
            val intent = Intent(this,ScriptVerifyActivity2::class.java)
            startActivity(intent)
        }

    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"  // 모든 파일 유형을 선택할 수 있도록 지정

        // 선택기에 표시할 기본 파일 이름 설정 (선택 사항)
        intent.putExtra(Intent.EXTRA_TITLE, "기본 파일 이름")

        startActivityForResult(intent, FILE_SELECT_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FILE_SELECT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // 선택된 파일의 URI 가져오기
            val selectedFileUri = data?.data

            // URI를 사용하여 파일 제목 가져오기
            val fileName = selectedFileUri?.let { uri ->
                contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                    if (cursor.moveToFirst()) {
                        val displayNameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                        if (displayNameIndex != -1) {
                            cursor.getString(displayNameIndex)
                        } else {
                            // The column doesn't exist in the cursor
                            null
                        }
                    } else {
                        // Cursor is empty
                        null
                    }
                }
            }

            // 가져온 파일 제목 사용하기
            fileName?.let { title ->
                // 파일 제목 사용 예시
                Log.d("SelectedFileTitle", title)
                binding.fileNameTv.setText(title+"  제출됨")
                binding.textView5.visibility=View.GONE
                binding.addFileIb.visibility = View.GONE
                binding.nextVerify2Btn.setBackgroundResource(R.drawable.main_btn)
                binding.nextVerify2Btn.isEnabled = true // 버튼 활성화
            }
        }
    }

}