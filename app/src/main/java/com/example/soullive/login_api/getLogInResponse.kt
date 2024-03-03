package com.example.soullive.login_api

data class getLogInResponse(
    val code: Int,
    val message: String,
    val result: ResultX,
    val status: Int
)