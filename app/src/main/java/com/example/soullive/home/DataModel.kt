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