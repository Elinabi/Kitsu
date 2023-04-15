package com.geektech.kitsu.models

import com.google.gson.annotations.SerializedName

data class DataItem(

    @SerializedName("links")
    val links: Links,

    @SerializedName("attributes")
    val attributes: Attributes,

    @SerializedName("id")
    val id: String = "",

    @SerializedName("type")
    val type: String = "",
)