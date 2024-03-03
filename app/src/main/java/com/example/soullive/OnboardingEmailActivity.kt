package com.example.soullive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.example.soullive.databinding.ActivityOnboardingEmailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnboardingEmailActivity : AppCompatActivity() {
    lateinit var binding: ActivityOnboardingEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOnboardingEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 텍스트 변경 이벤트를 감지
        binding.inputEmail.addTextChangedListener(textWatcher)


        binding.nextBtn.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            postCompanyInfo(email)
            val intent = Intent(this, OnboardingDoneActivity::class.java)
            startActivity(intent)
        }

        binding.root.setOnClickListener {
            // 화면의 다른 부분을 클릭하면 EditText의 포커스를 해제하고 키보드를 내림
            hideKeyboard()
        }

        binding.backBtn.setOnClickListener { //뒤로 가기 클릭 시
            finish()
        }
    }

    // 텍스트 변경 감지
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // 이메일이 입력되었을 때
            if (binding.inputEmail.text.isNotEmpty()) {
                // 버튼의 배경 변경
                binding.nextBtn.setBackgroundResource(R.drawable.main_btn)
                binding.nextBtn.isEnabled = true // 버튼 활성화
            } else {
                binding.nextBtn.setBackgroundResource(R.drawable.gray_btn)
                binding.nextBtn.isEnabled = false // 버튼 비활성화
            }
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun hideKeyboard() {
        binding.inputEmail.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun postCompanyInfo(email : String){

        val companyName = intent.getStringExtra("companyName")
        val companyType = intent.getStringExtra("companyType")
        val sharedPreferences = getSharedPreferences("my_token", Context.MODE_PRIVATE)
        val accessToken = sharedPreferences.getString("access_token", null)
        Log.d("토큰",accessToken.toString())
        Log.d("이름",companyName.toString())
        Log.d("타입1",companyType.toString())


        RetrofitClient.login.postSignUp(accessToken.toString(), companyName.toString(), companyType.toString(), email)
            .enqueue(object : Callback<SignUpResponse> {
                override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                    if (response.isSuccessful) {
                        // 회원가입 성공
                        val signUpResponse: SignUpResponse? = response.body()
                        Log.d("성공", signUpResponse.toString())
                        // 처리할 작업 수행
                    } else {
                        // 회원가입 실패
                        val errorMessage = "요청 실패: ${response.code()} ${response.message()}"
                        Log.e("API 요청 실패", errorMessage)
                        // 추가 정보 출력
                        try {
                            val errorBody = response.errorBody()?.string()
                            Log.e("API 응답 에러", errorBody ?: "에러 응답 본문이 없습니다.")
                        } catch (e: Exception) {
                            Log.e("API 응답 에러", "에러 본문을 읽는 중 에러가 발생했습니다.")
                        }
                    }
                }


                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    // 네트워크 오류 등으로 요청 실패
                    val errorMessage = "요청 실패: ${t.message}"
                    Log.e("API 요청 실패!", errorMessage, t)

                }
            })
    }
}