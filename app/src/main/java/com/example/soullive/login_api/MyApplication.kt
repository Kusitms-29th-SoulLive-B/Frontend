package com.example.soullive.login_api

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "4d96ece34b8bada4defe8a15b4f0eabb")
    }
}