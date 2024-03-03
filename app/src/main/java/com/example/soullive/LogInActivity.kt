package com.example.soullive

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.soullive.databinding.ActivityLogInBinding
import com.example.soullive.home.ViewPager1Fragment
import com.example.soullive.home.ViewPager2Fragment
import com.example.soullive.home.ViewPager3Fragment
import com.example.soullive.login_api.RetrofitClient
import com.example.soullive.login_api.getLogInResponse
import com.example.soullive.onboarding.OnboardingActivity
import com.google.gson.Gson
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.user.UserApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    lateinit var viewPager: ViewPager2

    class ViewPagerAdapter(
        fragmentManager: FragmentManager, lifecycle: Lifecycle
    ) : FragmentStateAdapter(fragmentManager, lifecycle) {

        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ViewPager1Fragment()
                1 -> ViewPager2Fragment()
                2 -> ViewPager3Fragment()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter

        // 뷰 페이지 변경 리스너 설정
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // 페이지가 변경될 때마다 bottom_bar 이미지 변경
                when (position) {
                    0 -> binding.bottomBar.setImageResource(R.drawable.splash_bottombar1)
                    1 -> binding.bottomBar.setImageResource(R.drawable.splash_bottombar2)
                    2 -> binding.bottomBar.setImageResource(R.drawable.splash_bottombar3)
                }
            }
        })

        // 저장된 토큰 꺼내기
        val sharedPreferences = getSharedPreferences("my_token", Context.MODE_PRIVATE)
        val accessToken = sharedPreferences.getString("access_token", null)

        Log.d("my log", ""+accessToken)


        KakaoSdk.init(this,getString(R.string.kakao_app_key))

        // 로그인 정보 확인
        /*UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "로그인 기록 없음", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Toast.makeText(this, "자동 로그인", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()공
            }
        }*/

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                // 로그인 실패
                Log.d("my log", "로그인 실패")
            }
            else if (token != null){
                // 로그인 성공
                Log.d("my log", "로그인 토큰 테스트" + token)

                // 토큰 저장
                val sharedPreferences = this.getSharedPreferences("my_token", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                val gson = Gson()
                val tokenJson = gson.toJson(token)

                editor.putString("kakao_token", tokenJson)  // 카카오 토큰 전체
                editor.putString("access_token", token.accessToken) // 액세스 토큰
                editor.apply()

                RetrofitClient.login.getLogIn("Bearer ${token.idToken}").enqueue(object :
                    Callback<getLogInResponse> {
                    override fun onResponse(call: Call<getLogInResponse>, response: Response<getLogInResponse>) {
                        Log.d("토큰", token.idToken.toString())
                        if (response.isSuccessful) {
                            val logInResponse = response.body()
                            Log.d("성공",response.body().toString())
                            if (logInResponse != null) {
                                if (logInResponse.result.isUser) {
                                    val intent = Intent(this@LogInActivity, MainActivity::class.java)
                                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                    finish()
                                } else {
                                    val intent = Intent(this@LogInActivity, OnboardingActivity::class.java)
                                    intent.putExtra("accessToken", logInResponse.result.accessToken)
                                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                    finish()
                                }
                            }
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

                    override fun onFailure(call: Call<getLogInResponse>, t: Throwable) {
                        // 네트워크 오류 등으로 요청 실패 처리
                        Log.e("로그인 호출 실패", "요청 실패: ${t.message}", t)
                    }
                })

                /*val intent = Intent(this, OnboardingActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()*/
            }
        }

        val kakao_login_button = findViewById<ImageButton>(R.id.login_btn) // 로그인 버튼

        kakao_login_button.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }

    }


}