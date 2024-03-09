package com.example.soullive.home

// 임시 모델
data class Model(
    val modelId: Int,
    val name: String,
    val job: String,
    val image: Int
)

// 모델 최근 광고 (임시 모델)
data class Ad(
    val modelImage: Int,
    val logo: Int
)

// 임시 모델
data class ModelResult(
    val modelId: Int,
    val ranking: Int,
    val name: String,
    val job: String,
    val company: String,
    val debut: String,
    val keyword1: String,
    val keyword2: String,
    val keyword3: String,
    val image: Int
)

// 홈 - 기업들이 선택한 모델
data class ModelSelected(
    val modelId: Int,
    val name: String,
    val job: String,
    val company: String,
    val companyImg: Int,
    val keyword1: String,
    val keyword2: String,
    val image: Int
)

// 홈 - 이런 모델은 어때요? 상세 모델
data class ModelAi(
    val modelId: Int,
    val name: String,
    val job: String,
    val keyword1: String,
    val keyword2: String,
    val image: Int,
    val age: String,
    val gender: String
)