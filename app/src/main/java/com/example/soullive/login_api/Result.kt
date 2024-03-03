package com.example.soullive.login_api

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("userId")
    val userId: Int
)