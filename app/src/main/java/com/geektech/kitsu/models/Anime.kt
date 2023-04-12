package com.geektech.kitsu.models

import com.google.gson.annotations.SerializedName

data class Anime<T>(
    @SerializedName("data")
    val data: List<T>?
)