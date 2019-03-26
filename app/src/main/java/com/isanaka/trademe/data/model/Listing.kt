package com.isanaka.trademe.data.model

import com.google.gson.annotations.SerializedName


data class Listing(
    @SerializedName("ListingId") val listingId: String,
    @SerializedName("Title") val title: String,
    @SerializedName("PictureHref") val pictureHref: String?,
    @SerializedName("PhotoUrls") val photoUrls: List<String>?
)