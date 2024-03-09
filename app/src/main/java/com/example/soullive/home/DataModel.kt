package com.example.soullive.home

// 임시 모델
data class Model(
    val modelId: Int,
    val name: String,
    val job: String,
    val image: String
)

// 모델 최근 광고 (임시 모델)
data class Ad(
    val modelImage: Int,
    val logo: Int
)
