package com.isanaka.trademe.data.model

import com.google.gson.annotations.SerializedName


data class CategoryResponse(@SerializedName("Subcategories") val Subcategories: List<Category>)