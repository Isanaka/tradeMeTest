package com.isanaka.trademe.data.model

import com.google.gson.annotations.SerializedName


data class Category(
    @SerializedName("Name") val name: String,
    @SerializedName("Number") val number: String
)