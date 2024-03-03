package com.example.soullive

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("userId")
    val userId: Int
)