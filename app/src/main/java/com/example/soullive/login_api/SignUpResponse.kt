package com.example.soullive.login_api

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: Result,
    @SerializedName("status")
    val status: Int
)